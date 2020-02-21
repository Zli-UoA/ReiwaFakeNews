TweenMax.set($("#line1"), {y:0,x:1000});
TweenMax.to($("#line1"),2, {x:0});
TweenMax.to($("#line1"),1, {delay:2,y:100,ease: Elastic.easeOut.config(1, 0.3)});
TweenMax.to($("#line1"),0.5, {rotation:-8,delay:1.5});
TweenMax.to($("#line1"),1, {scaleX:10,delay:1.5});

TweenMax.set($("#line2"), {y:0,x:-1000});
TweenMax.to($("#line2"),2, {x:0});
TweenMax.to($("#line2"),1, {delay:2,y:-100,ease: Elastic.easeOut.config(1, 0.3)});
TweenMax.to($("#line2"),0.5, {rotation:-8,delay:1.5});
TweenMax.to($("#line2"),1, {scaleX:10,delay:1.5});

TweenMax.set($(".desinks"), {opacity:0,scale:0});
TweenMax.to($(".desinks"),0.5, {display:'block',opacity:1});
//TweenMax.set($(".desinks"), {scale:0});
TweenMax.to($(".desinks"),0.5, {delay:2,scale:1,ease: Back.easeOut.config(1.7) });
TweenMax.to($(".desinks"),0.5, {rotation:-8,delay:1.5});
TweenMax.to($(".desinks"),1, {skewX:-8});

var el = document.querySelector('.desink');

el.addEventListener("DomContentLoaded", function() {
    // transition終了時の処理
    $(".mainSite").css("display", "none");

    setTimeout(function() {
        $('.anime').fadeOut();
    }, 1700);
});