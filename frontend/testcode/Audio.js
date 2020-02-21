//axiosを使わずmockの方
const music = new Audio('./sample2.mp3');

//これを３回ならす
function speak(){
    music.play();
    music.addEventListener('ended', (event) => {
        var text = "お疲れ様です。頑張ってください。ああああ、これでOK!";
        var uttr = new SpeechSynthesisUtterance(text);
        speechSynthesis.speak(uttr);
        uttr.onend = function () {
            speechSynthesis.cancel();
        }
    });
}





