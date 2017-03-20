package com.gqcp.wechat.menu;


import com.gqcp.common.wechat.WxClient;
import com.gqcp.common.wechat.menu.Menu;
import com.gqcp.common.wechat.util.JsonMapper;
import com.gqcp.wechat.QyWxClientFactory;
import com.gqcp.wechat.base.CorpSetting;
import com.gqcp.wechat.base.WxEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by exizhai on 9/25/2015.
 */
public class Menus {

    private static Logger logger = LoggerFactory.getLogger(Menus.class);
    private WxClient wxClient;

    public static Menus defaultMenus() {
        return with(CorpSetting.defaultSettings());
    }

    public static Menus with(CorpSetting corpSetting) {
        Menus menus = new Menus();
        menus.setWxClient(QyWxClientFactory.getInstance().with(corpSetting));
        return menus;
    }

    public void setWxClient(WxClient wxClient) {
        this.wxClient = wxClient;
    }

    public void create(int agent, Menu menu) {
        String url = WxEndpoint.get("url.menu.create");

        String json = JsonMapper.nonEmptyMapper().toJson(menu);
        logger.info("update menu: {}", json);
        wxClient.post(String.format(url, agent), json);
    }

    public void delete(int agent) {
        String url = WxEndpoint.get("url.menu.delete");
        wxClient.get(String.format(url, agent));
    }

    public Menu get(int agent) {
        String url = WxEndpoint.get("url.menu.get");
        String content = wxClient.get(String.format(url, agent));

        logger.debug("get menu: {}", content);

        MenuWrapper menuWrapper = JsonMapper.nonEmptyMapper().fromJson(content, MenuWrapper.class);
        return menuWrapper.getMenu();
    }

    /**
     * Created by exizhai on 9/27/2015.
     */
    public static class MenuWrapper implements Serializable {

        private Menu menu;

        public Menu getMenu() {
            return menu;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }
    }

}
