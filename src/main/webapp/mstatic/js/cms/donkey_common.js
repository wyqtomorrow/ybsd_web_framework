$(function(){
    $('#cmsListTpl').on('tap', 'a', function(){
        var href = $(this).attr('href');
        if(typeof href === 'undefined'){
            return false;
        }
        if($(this).attr('target') === '_blank'){
            window.open(href);
        }
        if(href.indexOf('#') < 0 || href.indexOf('#') > 1){
            window.open(href,'_self');
        }
    });
});