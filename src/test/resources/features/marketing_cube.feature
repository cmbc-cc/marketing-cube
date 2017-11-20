# language: zh-CN
功能: Marketing cube

  场景: 专属权益
    假如 I navigate to page "https://test.creditcard.cmbc.com.cn/home.$16897.html#/all"
    并且 I click on element having id "share_pop"
    那么 activity having title "民生爱奇艺联名卡 首刷专享特权" should be present
    并且 activity having title "民生白条联名卡 五星级自助餐二免一畅享" should be present
    并且 activity having title "嗨购11.11" should be present
    当 I click on activity having title "嗨购11.11"
    那么 gift having remark "进入大众点评APP购买美食团购/闪惠买单时使用。" should be present
    并且 gift having remark "进入大众点评APP订座电影票时使用。" should be present
    并且 gift having remark "进入大众点评APP购买美食团购/闪惠买单时使用。" should have button as "立即兑换"
    并且 button as "立即兑换" of gift having remark "进入大众点评APP购买美食团购/闪惠买单时使用。" should be disabled