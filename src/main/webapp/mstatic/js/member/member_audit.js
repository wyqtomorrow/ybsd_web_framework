$(function(){
    mui("body").on("tap", "#user_audit", function () {
        self.location.href = "/mob/member/queryUserAuditListView";
    });
    mui("body").on("tap", "#supply_audit", function () {
        self.location.href = "/mob/goods/queryGoodsSupplyAuditList";
    });
    mui("body").on("tap", "#percharse_audit", function () {
        self.location.href = "/mob/goods/queryGoodsPurcharseAuditList";
    });

});