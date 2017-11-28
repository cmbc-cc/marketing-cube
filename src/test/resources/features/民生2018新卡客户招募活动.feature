# language: zh-CN
功能: 2018新客户新卡招募礼领取平台

  场景大纲: 客户无资质
    假如 I navigate to page "https://test.creditcard.cmbc.com.cn/index.html?encryptStr=iNCCNqr5LAp/wnVtc4XBr7FzlLS1cS/PYZaxTNn/xRln8aYryzF2RRFwVYizQThV2Q8ORNZJSA25KmjxBYpXz6r2oHMPq9ljsXH6xwik55EhLQJxx98Yq6NG5J6ksBZZ0fKN0zfWWds3+zqUOrlomvVq955QdxUCyoEvgKc7BeI="
    并且 I click on element having id "share_pop"
    那么 activity having title "<title>" should be present
    当 I click on activity having title "<title>"
    #    那么 element having class "btn_dh" should have text as "查询资质信息"
    #    当 I click on element having class "btn_dh"
    那么 element having class "top_txt" should have text as "<top_txt>"
    并且 element having class "btn_dh" should have text as "<btn_dh>"
    并且 gift having remark "<gift_remark>" should be present
    当  I click on element having class "btn_dh"
    那么 element having class "btn_card" should have text as "<btn_card>"
    并且 element having class "btn_card" should have attribute "class" with value "btn_card disable ng-scope"
    例子:
      | title | btn_dh | btn_card | top_txt | gift_remark |
      | 2018新客户新卡招募礼领取平台  | 立即兑换 | 确认兑换 | 新卡招募五选一活动资质一次 | 颜色随机发货，具体以实物为准。|
