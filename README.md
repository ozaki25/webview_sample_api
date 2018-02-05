# webview_sample_api

## 起動手順

```
git clone https://github.com/ozaki25/webview_sample_api.git
cd webview_sample_api
mvn package
java -jar target/WebviewSample-0.0.1-SNAPSHOT.jar
```
- デフォルトだと8080ポートで起動します

## エンドポイント

|URL|メソッド|概要|
|:--|:--|:--|
|/|POST|MultipartFileのアップロード|
|/{id}.jpg|GET|{id}の画像のダウンロード|

## 関連リポジトリ

- Webアプリ
  - https://github.com/ozaki25/webview_sample_web
- スマホアプリ
  - https://github.com/ozaki25/webview_sample_native
