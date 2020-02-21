function send() {
    var text = document.form1.textarea1.value;
    var url = 'http://localhost:8080/news';
    var data = {text: text};

    fetch(url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}!
        headers:{
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(response => console.log('Success:', JSON.stringify(response)))
        .then(document.form1.textarea1.value = "")
        .catch(error => console.error('Error:', error));
}



