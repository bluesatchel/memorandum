"use strict";(self["webpackChunkvue_manage"]=self["webpackChunkvue_manage"]||[]).push([[356],{2356:function(t,e,s){s.r(e),s.d(e,{default:function(){return d}});var i=function(){var t=this,e=t._self._c;return e("div",{staticClass:"all"},[0==t.isSentense?e("el-card",[e("div",{staticClass:"value"},[e("p",{attrs:{id:"word"}},[t._v(" "+t._s(t.wordInfo.word)+" ")])]),e("div",{staticClass:"announce"},[t._v(" 英式读音 "+t._s(t.wordInfo.uk_phonetic)+" "),e("el-button",{ref:"uk",attrs:{type:"primary",plain:"",icon:"el-icon-service",size:"mini"},on:{click:t.ukSpeech}}),e("br"),t._v(" 美式读音 "+t._s(t.wordInfo.us_phonetic)+" "),e("el-button",{ref:"us",attrs:{type:"primary",plain:"",icon:"el-icon-service",size:"mini"},on:{click:t.usSpeech}})],1),e("h3",[t._v("释义")]),e("div",{staticClass:"explains"},t._l(t.wordInfo.explains,(function(s,i){return e("ul",{key:i},[e("li",[t._v(" "+t._s(s)+" ")])])})),0),t.wordInfo.wordGroup.length?e("div",[e("h3",[t._v("词组")]),t._l(t.wordInfo.wordGroup,(function(s,i){return e("ul",{key:i},[e("li",[t._v(" "+t._s(s)+" ")])])}))],2):t._e(),this.flag?t._e():e("div",[e("h3",[t._v("网络释义及词组")]),t._l(t.wordInfo.web,(function(s,i){return e("ul",{key:i},[e("li",[t._v(" "+t._s(s.key)+" "+t._s(s.value)+" ")])])}))],2),t.wordInfo.sentences.length?e("div",[e("h3",[t._v("双语例句")]),t._l(t.wordInfo.sentences,(function(s,i){return e("ul",{key:i},[e("li",[t._v(" "+t._s(s.en)+" "+t._s(s.cn)+" ")])])}))],2):t._e()]):t._e(),t.isSentense?e("el-card",[e("h2",[t._v("句子")]),e("h4",[t._v(t._s(t.sentence.query)+" ")]),e("br"),e("h2",[t._v("释义")]),e("h4",[t._v(" "+t._s(t.sentence.translation)+" ")]),e("el-button",{ref:"uk",attrs:{type:"primary",plain:"",icon:"el-icon-service",size:"mini"},on:{click:t.sentenseSpeech}})],1):t._e(),e("p",{attrs:{id:"index"}},[t._v(t._s(t.n+1)+"/"+t._s(t.wordList.length))]),e("el-button",{attrs:{type:"primary",plain:"",id:"btn1"},on:{click:t.previous}},[t._v("上一个 ")]),e("el-button",{attrs:{type:"success",plain:"",id:"btn2"},on:{click:t.next}},[t._v("下一个 ")])],1)},n=[],r=s(9669),o=s.n(r),h={name:"MyWords",data(){return{currentWord:"",wordList:[],wordInfo:{},phoneticArr:[],basic:{},arr:[],keyArr:[],flag:!0,isSentense:!1,sentence:{},n:0}},methods:{open2(t){this.$message({showClose:!0,message:t,type:"success"})},getWordInfo(t){o()({method:"post",url:"http://121.40.113.226:7777/word/getWordInfo",data:this.$qs.stringify({word:t})}).then((t=>{400==t.data.status?(this.getFromYouDao(this.wordList[this.n]),this.wordInfo.sentences=[],this.wordInfo.wordGroup=[],this.flag=!1):(this.isSentense=!1,this.flag=!0,console.log(t),this.wordInfo=t.data.data)}))},next(){this.n<this.wordList.length-1?(this.n++,this.getWordInfo(this.wordList[this.n])):this.open2("已经是最后一个单词了,今日共背了"+this.wordList.length+"个")},previous(){0==this.n?this.open2("已经到头了"):this.n>0&&(this.n--,-1!=this.n&&this.getWordInfo(this.wordList[this.n]))},ukSpeech(){this.flag?this.FileukSpeech():this.YDukSpeech()},usSpeech(){this.flag?this.FileusSpeech():this.YDusSpeech()},FileukSpeech(){let t=new Audio;t.src="http://121.40.113.226/audio/"+this.wordInfo.word+"_uk.mp3",t.play()},FileusSpeech(){let t=new Audio;t.src="http://121.40.113.226/audio/"+this.wordInfo.word+"_us.mp3",t.play()},getFromYouDao(t){let e="mtKD1CVzlGrj2rcSxK4DzTPz9m4zRscM",s="50649feb1569418e",i=(new Date).getTime(),n=Date.parse(new Date)/1e3;o()({method:"post",url:"http://121.40.113.226:7777/api/",headers:{"content-type":"application/x-www-form-urlencoded"},data:this.$qs.stringify({q:t,from:"en",to:"zh-CHS",salt:i,curtime:n,appKey:s,sign:this.$sha256(s+this.truncate(t)+i+n+e),signType:"v3",ext:"mp3",voice:"0",strict:"true"})}).then((e=>{console.log(e.data),0==e.data.isWord&&(this.isSentense=!0,this.sentence.query=e.data.query,this.sentence.translation=e.data.translation,this.sentence.speakUrl=e.data.speakUrl),this.basic=e.data.basic,this.arr=Object.values(this.basic),this.keyArr=Object.keys(this.basic);let s=0;for(s;s<this.keyArr.length;s++)if("uk-phonetic"==this.keyArr[s])break;this.phoneticArr[0]=this.arr[s];let i=0;for(i;i<this.keyArr.length;i++)if("us-phonetic"==this.keyArr[i])break;this.phoneticArr[1]=this.arr[i],console.log(this.phoneticArr),this.wordInfo.uk_phonetic=this.phoneticArr[0],this.wordInfo.us_phonetic=this.phoneticArr[1],this.wordInfo.sentences=[],this.wordInfo.word=t,this.wordInfo.explains=this.basic.explains,this.wordInfo.wordGroup=[],this.wordInfo.web=e.data.web}))},truncate(t){let e=t.length;return e<=20?t:t.substring(0,10)+e+t.substring(e-10,e)},YDukSpeech(){let t=new Audio,e=0;for(e;e<this.keyArr.length;e++)if("uk-speech"==this.keyArr[e])break;t.src=this.arr[e],t.play()},YDusSpeech(){let t=new Audio,e=0;for(e;e<this.keyArr.length;e++)if("us-speech"==this.keyArr[e])break;t.src=this.arr[e],t.play()},finished(t){alert("今天背了"+t+"条")},sentenseSpeech(){let t=new Audio;t.src=this.sentence.speakUrl,t.play()}},mounted(){null!=this.$store.state.uid&&""!=this.$store.state.uid&&void 0!==this.$store.state.uid||(alert("请先登录"),this.$router.push("/login")),o()({method:"post",url:"http://121.40.113.226:7777/word/todayWords",data:{uid:this.$store.state.uid}}).then((t=>{this.n=0,console.log(t),t.data.data.forEach((t=>{this.wordList.push(t.value)})),this.getWordInfo(this.wordList[0]),0==this.wordList.length&&alert("今天还没有单词要背哦,先去添加单词吧,添加完一般第二天才可以获取,记得今天先背添加的单词哦")}))}},a=h,l=s(1001),c=(0,l.Z)(a,i,n,!1,null,"d121a768",null),d=c.exports}}]);
//# sourceMappingURL=356.3fafefca.js.map