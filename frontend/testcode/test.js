//axiosを使わずmockの方
var music = new Audio();

//var text = ["お疲れ様です。頑張ってください。ああああ、これでOK!","hoge","fuga"];

music.preload = "auto";
music.src = "./newssound-standard.mp3";
music.load();


function play() {
    music.loop = false;
    var playmusic = music.play();
    playmusic;
    console.log("hoge");
    speak();
    if (playmusic  !== undefined){
        playmusic.then( _ => {
            stop();
        })
    }
}

function stop() {
    music.pause();
    music.currentTime = 0;
}



function speak(){
    music.play();
    music.addEventListener('ended', (event) => {
        console.log('Video stopped either because 1) it was over, ' +
            'or 2) no further data is available.');
    });
        var text = "お疲れ様です。頑張ってください。ああああ、これでOK!";
        var uttr = new SpeechSynthesisUtterance(text);

        //声を指定
        var voice = speechSynthesis.getVoices().find(function(voice){
            return voice.name === 'Google 日本語';
        });

        // 取得できた場合のみ適用する
        if(voice){
            uttr.voice = voice;
        }
        speechSynthesis.speak(uttr);
        uttr.onend = function () {
            //alert("終了");
            console.log("aaaaaaaa")

        }
}



