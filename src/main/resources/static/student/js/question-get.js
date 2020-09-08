/**
 * 通过Ajax获取试题
 */
// $(function () {
//     function getUrlParam(name) {
//         var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
//         var r = window.location.search.substr(1).match(reg);  //匹配目标参数
//         if (r != null) return unescape(r[2]); return null; //返回参数值
//     }
//     var collegeKind = getUrlParam('collegeKind');
//     var subjectKind = getUrlParam('subjectKind');
//     console.log(collegeKind,subjectKind)
//     $.ajax({
//         type:"post",
//         url: "/subject/"+collegeKind+"/"+subjectKind,
//         success:function (data) {
//             /*for (var i=0;i<3;i++){
//                 $("#single ul").append(data.data[i].options[0]);
//             }*/
//             //for (var i=0;i<3;i++) {
//             var  res = $.parseJSON(data.data[0].options)
//
//                 console.log(res.blog)
//             //}
//
//         }
//
//     })
// });
function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
    var collegeKind = getUrlParam('collegeKind');
    var subjectKind = getUrlParam('subjectKind');

const app =new Vue({
    el:"#single",
    data(){
        return{
            questions:new Array(),
            options:new Array(),
        }
    },
    created(){
        axios.post("/subject/"+collegeKind+"/"+subjectKind).then(
            (res)=>(this.questions=(res.data.data)),
            // (res)=>this.questions=(eval('(' +res.data.data[0].options + ')')),
            // (res1)=>console.log((res1.data.data))
        )
    }
})