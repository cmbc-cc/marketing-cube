# language: zh-CN
@new
功能: 京东白条联名卡

  场景: 礼品兑换
    当 访问活动 "京东白条联名卡 专享特权"
    那么 兑换按钮可用
    并且 展示话术 "恭喜您获得自助餐二免一畅享特权！"
    当 兑换礼品
      | title | remark |
      | 星巴克大杯手工调制饮品 | 凭电子券至星巴克全国指定门店兑换任意大杯手工调制饮料 |
    并且 输入正确图片验证码
    并且 确认兑换
    那么 下单展示话术 "恭喜您免费获得民生白条联名卡专享特权-——五星级酒店自助餐双人免一电子券一张！"