# webview_sample_api

## 起動手順

```
git clone https://github.com/ozaki25/webview_sample_api.git
cd webview_sample_api
mvn package
java -jar target/WebviewSample-0.0.1-SNAPSHOT.jar
```

## エンドポイント

|URL|メソッド|概要|
|:--|:--|:--|
|/|POST|MultipartFileのアップロード|
|/{id}.jpg|GET|{id}の画像のダウンロード|


