  //axiosを使いサーバーと通信する方
  import axios from 'axios'

  var newslist = [text1, text2, text3];

  axios.get('http://0.0.0.0:8080')
  .then(function (response) {
    newslist = response.data;

  })