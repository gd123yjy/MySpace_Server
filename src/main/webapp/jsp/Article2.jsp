<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Immaculate | One Page Portfolio Website Template</title>
    <link rel="stylesheet" type="text/css" href="../../css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/style2.css" media="screen"/>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/shou.css"/>
    <!--
            <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
            <link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
             -->
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/jquery.mousewheel.js"></script>
    <script type="text/javascript" src="../../js/jquery.scrollTo-1.4.2-min.js"></script>
    <script type="text/javascript" src="../../js/waypoints.min.js"></script>
    <script type="text/javascript" src="../../js/navbar.js"></script>
    <script type="text/javascript" src="../../js/focusBoxController.js "></script>
    <script type="text/javascript" src="../../js/jquery.raty.min.js"></script>
    <script type="text/javascript" src="../../js/HTMLMaker.js"></script>
    <!--
        <script type="text/javascript" src="js/bootstrap.js"></script>
         -->

    <script type="text/javascript">
        document.onkeydown = function (e) {
            var isie = (document.all) ? true : false;
            var key;
            var ev;
            if (isie) {//IE浏览器
                key = window.event.keyCode;
                ev = window.event;
            } else {//火狐浏览器
                key = e.which;
                ev = e;
            }
            if (key == 9) {//IE浏览器
                if (isie) {
                    ev.keyCode = 0;
                    ev.returnValue = false;
                } else {//火狐浏览器
                    ev.which = 0;
                    ev.preventDefault();
                }
            }
        };
        $(function () {
            var maxWord = 400;
            var listSize = ${request.paragraph_list==null?0:request.paragraph_list.size()};

            //add focusBox Controller
            for (var i = 1; i < listSize + 1; i++) {
                focusBoxController('kakaFocus' + i, i - 1, listSize + 1);
            }
            focusBoxController('add_paragraph', listSize, listSize + 1);

            //add mouseWheel effect
            $('.banner')
                    .mousewheel(function (event, delta) {
                        if (delta > 0)
                            $(this).children('a.btn_prev').trigger('click');
                        else if (delta < 0)
                            $(this).children('a.btn_next').trigger('click');
                        return false; // prevent default
                    });

            //count TextArea
            countTextAreaMakerGrounp("cTextArea", listSize + 1);
            for (var i = 0; i < listSize + 1; i++) {
                var content = "content" + i;
                $("#" + content).focus(function () {
                    $(this).keydown(function () {
                        check($(this));
                    });
                    $(this).keyup(function () {
                        check($(this));
                    });
                    try {
                        $(this).onpaste(function () {
                            check($(this));
                        });
                    } catch (e) {
                        //alert(e.message);
                    }
                });
            }
            $("#note").focus(function () {
                $("#note").keyup(checkn);
                $("#note").keydown(checkn);
                $("#note").onpaste(checkn);
            });

            function check(trigger) {
                //var content = "content" + my_num;
                var str = trigger.val();
                var info = maxWord - str.length;
                info = info + "";
                if (info.indexOf('.') > 0)
                    info = info.substring(0, info.indexOf('.'));
                if (str.length <= maxWord) {
                    var my_num = getContentNum(trigger);
                    $("#" + ("info1" + my_num)).html("还能输入");
                    $("#" + ("info0" + my_num)).html(info).css('color', 'gray');
                    $('#' + ("button" + my_num)).removeAttr("disabled");
                } else {
                    info = info.substr(1)
                    $("#" + ("info1" + my_num)).html("超出");
                    $("#" + ("info0" + my_num)).html(info).css('color', 'red');
                    $('#' + ("button" + my_num)).attr('disabled', "true");
                }
            }

            function getContentNum(content) {
                return (content.attr("id").charCodeAt(7))-48;
            }

            function checkn() {
                var str = $("#note").val();
                var info = 600 - str.length;
                info = info + "";
                if (info.indexOf('.') > 0)
                    info = info.substring(0, info.indexOf('.'));
                if (str.length <= 600) {
                    $("#info1n").html("还能输入");
                    $("#info0n").html(info).css('color', 'gray');
                    $('#buttonn').removeAttr("disabled");
                } else {
                    info = info.substr(1)
                    $("#info1n").html("超出");
                    $("#info0n").html(info).css('color', 'red');
                    $('#buttonn').attr('disabled', "true");
                }
            }

            function ml_close_demo() {
                $('#float-news').animate({
                    left: '-450px'
                }, 300, function () {
                    $('#float-open').delay(50).animate({
                        left: '-2px'
                    }, 300);
                });
            }

            function ml_open_demo() {
                $('#float-open').animate({
                    left: '-70px'
                }, 100, function () {
                    $('#float-news').delay(50).animate({
                        left: '0px'
                    }, 300);
                });
            }

            function m2_close_demo() {
                $('#float-news2').animate({
                    left: '-450px'
                }, 300, function () {
                    $('#float-open2').delay(50).animate({
                        left: '-2px'
                    }, 300);
                });
            }

            function m2_open_demo() {
                $('#float-open2').animate({
                    left: '-70px'
                }, 100, function () {
                    $('#float-news2').delay(50).animate({
                        left: '0px'
                    }, 300);
                });
            }

            $('#float-close').click(function () {
                ml_close_demo();
                return false;
            });
            $('#open-btn').click(function () {
                ml_open_demo();
                return false;
            });
            $('#float-close2').click(function () {
                m2_close_demo();
                return false;
            });
            $('#open-btn2').click(function () {
                m2_open_demo();
                return false;
            });

            for (var i = 0; i < listSize; i++) {
                starHTMLMakerGrounp('starInfo', i, listSize + 1);
            }
            starHTMLMakerGrounp('add_paragraph_starInfo', listSize, listSize + 1);
            /*starHTMLMakerGrounp('starInfo', 0, 5);
             starHTMLMakerGrounp('starInfo', 1, 5);
             starHTMLMakerGrounp('starInfo', 2, 5);
             starHTMLMakerGrounp('starInfo', 3, 5);
             starHTMLMakerGrounp('starInfo', 4, 5);*/
        })
    </script>


</head>
<body>
<div class="container">
    <header>
        <s:if test="#session.username != null">
            <h5 style="float:right;">Welcome Back! <a href="userManage.action"><s:property
                    value="#session.username"></s:property></a><a href="logout.action">&emsp;log out</a></h5><br>
        </s:if>
        <s:else>
            <h5 style="float:right;"><a href="welcome.jsp">&emsp;log in</a></h5><br>
        </s:else>
    </header>
</div>
<div class="weiduduan clearfix">
    <div class="float-open" id="float-open"
         style="left:-2px;top:75px; background:url(../../images/note.png) no-repeat;background-size:90% 90%;background-position:center;">
        <a class="open-btn" id="open-btn" href="javascript:void(0);">&gt;</a></div>
    <div class="float-news" id="float-news" style="left:-450px;top:25px">
        <a class="float-close" id="float-close"
           style="background:url(../../images/x.png) no-repeat left top;background-size:100% 100%;"
           href="javascript:void(0);">X</a>
        <div class="newslist">
            <h3>笔记</h3>
            <form action="saveNote">
                <input name="article_id" style="display:none;" value="${article_id}"/>
                <input name="chapter_id" style="display:none;" value="${chapter_id}"/>
                <table width="290px" border="0">
                    <tr>
                        <textarea name="note" id="note" cols="40" rows="18" style="overflow: auto;"><s:property
                                value="#request.note"></s:property></textarea><!--笔记的textarea在这里的-->
                    <tr>
                    <tr>
                        <td><input id="buttonn" type="submit" class="button" style="width:150px" value="保存笔记"/></td>
                        <!--笔记的提交按钮在这里的-->
                        <td>
                            <div style="vertical-align: bottom; height: 20px; line-height: 20px; margin: 0px;color: Gray;">
                                <label id="info2n" style="float: right; font-size: 12px;">个字</label>
                                <span id="info0n" style="float: right; font-size: 20px; font-weight: bold;">600</span>
                                <label id="info1n" style="float: right; font-size: 12px;">还能输入</label>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <!--直接搜索外链不用管-->
    <div class="float-open" id="float-open2"
         style="left:-2px; top:480px;background:url(../../images/search.png) no-repeat;background-size:90% 90%;background-position:center;">
        <a class="open-btn" id="open-btn2" href="javascript:void(0);">&gt;</a></div>
    <div class="float-news" id="float-news2" style="left:-450px; top:430px; width:320px;height:175px">
        <a class="float-close" id="float-close2"
           style="background:url(../../images/x.png) no-repeat;background-size:100% 100%;" href="javascript:void(0);">X</a>
        <div class="newslist">
            <h3>搜索</h3>
            <ul>
                <li>
                    <form id="bdfm" target="_blank" name="bdfm" method="get" action="http://www.baidu.com/s">
                        <input type="text" id="search1" name="word" style="width:200px"/>
                        <input type="submit" class="button" style="width:100px" value="百度一下"/>
                    </form>
                </li>
                <li>
                    <form action="http://www.google.com/search" target="_blank" method="get">
                        <input type="text" name="q" size="20" maxlength="255" style="width:200px" value=""/>
                        <input type="submit" class="button" name="btnG" style="width:100px" value="Google一下"/>
                    </form>
                </li>
                <li>
                    <form action="http://www.bing.com/search" target="_blank" method="get">
                        <input type="text" name="q" size="20" maxlength="255" style="width:200px" value=""/>
                        <input type="submit" class="button" name="btnG" style="width:100px" value="Bing一下"/>
                    </form>
                </li>
            </ul>
        </div>
    </div>
    <!--以上是直接搜索外链不用管-->
</div> <!-- weiduduan End -->


<input id="addParagraph_article_id" type="text" style="display:none; " value="${article_id}"/>
<input id="addParagraph_chapter_id" type="text" style="display:none;" value="${chapter_id}"/>

<div class="wrapper">

    <section id="home">
        <header>
            <h1>Immaculate</h1>
        </header>
        <div class="nav-container">
            <nav>
                <ul>
                    <li><a href="#home" class="selected">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#shortcodes">Shortcodes</a></li>
                    <li><a href="#gallery">Gallery</a></li>
                </ul>
                <div class="nav-left"></div>
                <div class="nav-right"></div>
                <div class="nav-above"></div>
            </nav>
        </div>

        <select id="select" style="width:300px;float:right" onchange="self.location.href=options[selectedIndex].value">
            <s:iterator value="#request.chapter_list" id="chapter" status="st">
                <option value="showArticle.action?article_id=${article_id}&chapter_id=${chapter[0]}"
                        <s:if test="%{#chapter[0] == chapter_id}">selected="true"</s:if>
                >
                    第<s:property value="1+#st.index"></s:property>章：<s:property value="#chapter[1]"></s:property>
                </option>
            </s:iterator>
            <!--
            <option value ="volvo">第一章：世界和平</option>
            <option value ="saab">第二章：我在这里</option>
            <option value="opel">第三章：放逐</option>
            <option value="audi">第四章：解放</option>
             -->
        </select>

        <input name="article_id" value="#article_id" style="display:none;"/>
        <s:set name="chapter_id" value="#chapter_id"></s:set>

        <s:iterator value="#request.paragraph_list" id="my_paragraph_list" status="my_st">
            <div class="banner" id="kakaFocus${my_st.index+1}">
                <a class="btn_prev" title="上一个" href="#">Previous</a>
                <a class="btn_next" title="下一个" href="#">Next</a>

                <div class="banner_pic">
                    <ul>
                        <s:iterator value="#my_paragraph_list" id="paragraph" status="st">
                            <li><a href="#"><img width="630" height="210" src="images/pic_0${st.index + 1}.jpg"
                                                 title="<s:property value="#paragraph.content"/>"
                                                 alt="<s:property value="#paragraph.content"/>"/></a></li>
                            <%--<input type="text" style="display: none;"
                                   value="<s:property value="#st.index+1"/>"/>--%>
                        </s:iterator>
                        <s:bean name="org.apache.struts2.util.Counter">
                            <s:param name="first" value="#my_paragraph_list.size() + 1"/>
                            <s:param name="last" value="5"/>${st.index}
                            <s:iterator>
                                <li><a href="#"><img width="630" height="210" src="images/pic_0<s:property/>.jpg"
                                                     alt=""/></a></li>
                                <%--<input type="text" style="display: none;" value="-1"/>--%>
                            </s:iterator>
                        </s:bean>

                        <li>
                            <div class="cTextArea${my_st.index}" width="630" height="210"/>
                            <!--这里将会用来填充输入框 在本文件的61行处 countTextAreaMakerGrounp函数负责生成（在HTMLmaker中）-->
                        </li>
                    </ul>
                </div>
                <div class="banner_info">
                    <ul>
                        <s:iterator value="#my_paragraph_list" id="paragraph" status="st">
                            <li>
                                <h4><a href="#">${paragraph.content}</a></h4>
                                <div class="ext" id="starInfo${my_st.index}${st.index}"/>
                            </li>
                        </s:iterator>
                        <s:bean name="org.apache.struts2.util.Counter">
                            <s:param name="first" value="#my_paragraph_list.size()+1"/>
                            <s:param name="last" value="5"/>
                            <s:iterator>
                                <li>
                                    <h4><a href="#">没有其他版本哟，快来投稿吧！</a></h4>
                                    <div class="ext" id="starInfo${my_st.index}<s:property/>"/>
                                </li>
                            </s:iterator>
                        </s:bean>

                        <li>
                            <h4><a href="#">我的看法</a></h4>
                            <div class="ext" id="starInfo${my_st.index}5"/>
                        </li>
                    </ul>
                </div>
                <div class="banner_count">1</div>
            </div>
            <!--banner end-->
        </s:iterator>
    </section>

    <section id="about"></section>

    <section id="shortcodes">
        <div class="banner" id="add_paragraph">

            <div class="banner_pic">
                <li>
                    <div class="cTextArea${request.paragraph_list==null?0:request.paragraph_list.size()}" width="630"
                         height="210"/>
                    <!--这里将会用来填充输入框 在本文件的61行处 countTextAreaMakerGrounp函数负责生成（在HTMLmaker中）-->
                </li>
            </div>
            <div class="banner_info">

                <li>
                    <h4><a href="#">新增段落</a></h4>
                    <div class="ext" id="add_paragraph_starInfo"/>
                </li>
            </div>
            <div class="banner_count">1</div>
        </div>
    </section>

    <section id="gallery"></section>

</div>
</body>
</html>