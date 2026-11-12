'use strict';
const assert = require('assert');
const path = require('path');
const childProcess = require('child_process');
const Module = require('module');
const parentRequire = (Module.createRequire || Module.createRequireFromPath)(require.resolve('source-map-resolve'));
const decoderPath = parentRequire.resolve('decode-uri-component');
const decode = require(decoderPath);
assert.strictEqual(require(path.join(path.dirname(decoderPath), 'package.json')).version, '0.5.1-zli.0');
if (process.argv[2] === '--stress') {
  assert.strictEqual(decode('%FE%FF'.repeat(5000)), '\uFFFD\uFFFD'.repeat(5000));
  assert.strictEqual(decode('%E3%81%82'.repeat(5000)), 'あ'.repeat(5000));
  assert.strictEqual(decode('%C2'.repeat(5000)), '\uFFFD'.repeat(5000));
  process.exit(0);
}
for (const pair of [['a%20b', 'a b'], ['%E3%81%82', 'あ'], ['a+b', 'a+b'], ['%', '%'], ['%G0', '%G0'], ['%FE%FF', '\uFFFD\uFFFD'], ['%C2', '\uFFFD']]) {
  assert.strictEqual(decode(pair[0]), pair[1]);
}
assert.throws(() => decode(null), TypeError);
const stress = childProcess.spawnSync(process.execPath, [__filename, '--stress'], { timeout: 2000, encoding: 'utf8' });
assert.ifError(stress.error);
assert.strictEqual(stress.status, 0, stress.stderr);
const resolve = require('source-map-resolve');
const map = { version: 3, sources: ['original.js'], names: [], mappings: 'AAAA' };
const code = '//# sourceMappingURL=a%20b.map';
const read = url => { assert(url.endsWith('/a b.map'), url); return JSON.stringify(map); };
assert.deepStrictEqual(resolve.resolveSourceMapSync(code, '/tmp/generated.js', read).map, map);
const customDecode = require('source-map-resolve/lib/decode-uri-component');
assert.strictEqual(customDecode('a+b%20c'), 'a+b c');
resolve.resolveSourceMap(code, '/tmp/generated.js', (url, callback) => {
  try { callback(null, read(url)); } catch (error) { callback(error); }
}, (error, result) => {
  assert.ifError(error);
  assert.deepStrictEqual(result.map, map);
  console.log('decoder normal/malformed/type checks, bounded stress, source-map-resolve sync/async integration passed');
});
