function send() {
    const text = document.form1.textarea1.value;
    const url = 'http://35.208.182.27:8492/news';
    const data = {text: text};

    fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers:{
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(response => console.log('Success:', JSON.stringify(response)))
        .then(document.form1.textarea1.value = "")
        .catch(error => console.error('Error:', error));
}


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


window.addEventListener('DOMContentLoaded', function () {
    $(".mainSite").css("display", "none");

    setTimeout(function() {
        $('.anime').fadeOut();
    }, 3000);
    $(".mainSite").css({opacity:'0'});
    setTimeout(function(){
        $(".mainSite").css("display", "block");
        $(".mainSite").stop().animate({opacity:'1'},1000);
    },3300);
});


