https://docs.live2d.com/cubism-sdk-tutorials/sample-build-web/?locale=ja

refer to https://github.com/tatsuteb/Cubism4WebGL_Samples/

sdkが配布サイトから直接ダウンロードしなければならなかったため、cloneではなくダウンロードしました。




依存インストールには npm 9 以上を使用してください（検証環境: Node.js 24 / npm 11.9）。ローカル依存を含む lockfile v3 と overrides を利用するため、古い npm では再現できません。
`npm ci` の後、`npm run test:decoder` で URI 復号と source-map-resolve の回帰検査を実行できます。
`vendor/decode-uri-component` は上流 0.5.1 の復号アルゴリズムを保持したローカル CommonJS 互換版です。ソース・整合性・更新手順は同ディレクトリの README を参照してください。このローカル版はレジストリから自動更新されないため、上流の修正や脆弱性情報を別途確認してください。
