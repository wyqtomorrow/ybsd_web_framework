mui(".mui-search").on('tap', '#search', function () {
    var searchCon = $("#searchCon").val();
    $("#search").attr("disabled", true);
    self.location.href = "/mob/goods/goodsSearch?keyWords="+searchCon;
});


