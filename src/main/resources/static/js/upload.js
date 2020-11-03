var fileList ;
// var savePath = "E:\\JavaWorkPlace\\PersonTest\\lankerenpan\\src\\main\\resources\\upload\\";
// var myhost = "http://localhost:8080/ryder/";

var savePath = "/usr/local/lankeren/lankerenpan/";
var myhost = "http://182.61.16.76:8080/ryder/";


function uploadClick() {

    layer.open({
        title: 'upload'
        , type: 2
        , area: ["1080px", "500px"]
        , skin: 'layui-layer-rim'
        , content: "html/upload.html"
        , cancel: function () {
            // 右上角关闭事件的逻辑
            // 表格重载
            fileList.reload({
                elem: "#test"
            });
        }
    });

}






