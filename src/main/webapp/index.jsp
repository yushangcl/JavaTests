<html>
<body>
<script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>

<script type="text/javascript">
    var goEasy = new GoEasy({appkey: 'BS-5bbef827b46b4840ba72d25c2a5c8c9d'});
    goEasy.subscribe({
        channel: 'hello-demo',
        onMessage: function (message) {
            alert('接收到消息:' + message.content);//拿到了信息之后，你可以做你任何想做的事
        }
    });
</script>

<h2> 测试 </h2>
<button onclick = "send"> send </button>
</body >
</html >