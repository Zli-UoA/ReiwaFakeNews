Local CommonJS compatibility build of decode-uri-component 0.5.1.

Source: https://registry.npmjs.org/decode-uri-component/-/decode-uri-component-0.5.1.tgz
Tarball integrity: sha512-vWHQkXgg2cE3BB4rR0c+PYw9BCQzLoNIRMI7AunIkZst74tw/vpPp7VLoYtsR/cy1f55g3XDWUslfeCZjiZJyA==
Upstream index.js SHA256: 6a86ac891edf15c5efa0841ebb31935e3669d58b98318b57d7b08a4530317cb0

The only source transformation is `export default function decodeUriComponent(` to `module.exports = function decodeUriComponent(`. The upstream decoding algorithm and MIT license are retained. This local build supplies a synchronous function to source-map-resolve 0.5.x; installing the upstream ESM package directly would break that API. This is a local compatibility build, not an upstream release or an upstream Node.js support claim.

When updating, verify the public tarball integrity, repeat only the export transformation, retain the license, and run `npm run test:decoder`. Review upstream changes and advisories: the local copy does not receive automatic registry updates.
