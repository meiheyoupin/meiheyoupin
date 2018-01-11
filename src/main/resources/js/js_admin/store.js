
    const vm = new Vue({
        el:'#app',
        data:{
            list:{}
        },
        created:function () {
            var that = this
            $.ajax({
                url:'platform/unauditStores',
                type:'get',
                datatype:'json',
                success:function (data) {
                    console.log(data);
                    if(data.code==200){
                        that.list = data.unauditStores;
                    }else {
                        alert("default");
                    }
                }
            })
        }
    });
