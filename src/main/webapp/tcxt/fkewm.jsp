<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" /> 
    <title>Document</title>
    <style type="text/css">
    	#qrcode{
    		margin-top:90px;
    		margin-left:500px;
    	}
    </style>
  </head>
  <body>
    <div id="qrcode"></div>
  </body>
  <script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://cdn.staticfile.org/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
  <script>
    jQuery(function() {
    	var content = "待生成二维码的内容";
        var utf8Content = utf16to8(content); // 将内容转换成 UTF-8 编码格式
        //最简单方式
        jQuery('#qrcode').qrcode({
        text: utf8Content  // 传递转换后的内容给 qrcode 插件
    });
	<!-- 转编码格式，原始二维码不能使用中文 -->
      function utf16to8(str) {
        var out, i, len, c;
        out = "";
        len = str.length;
        for (i = 0; i < len; i++) {
          c = str.charCodeAt(i);
          if (c >= 0x0001 && c <= 0x007f) {
            out += str.charAt(i);
          } else if (c > 0x07ff) {
            out += String.fromCharCode(0xe0 | ((c >> 12) & 0x0f));
            out += String.fromCharCode(0x80 | ((c >> 6) & 0x3f));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3f));
          } else {
            out += String.fromCharCode(0xc0 | ((c >> 6) & 0x1f));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3f));
          }
        }
        return out;
      }
    });
  </script>
</html>