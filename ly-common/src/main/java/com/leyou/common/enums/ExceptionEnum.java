package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnum{

    PRICE_CANNOT_BE_NULL(400,"价格不能为空！"),
    CATEGORY_NOT_FOND(404,"商品分类没查到"),
    BRAND_NOT_FOUND(404,"品牌不存在"),
    BRAND_SAVE_ERROR(500,"新增品牌失败"),
    BRAND_UPDATE_ERROR(500,"修改品牌失败"),
    BRAND_DELETE_ERROR(500,"商品删除失败"),
    UPLOAD_FILE_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(400,"文件类型无效"),
    SPEC_GROUP_NOT_FOND(404,"商品规格组不存在"),
    ADD_GROUP_ERROR(500,"添加商品规格组失败"),
    UPDATE_GROUP_ERROR(500,"更新商品规格组失败"),
    DELETE_GROUP_ERROR(500,"删除商品规格组失败"),
    SPEC_PARAM_NOT_FOND(404,"商品参数不存在"),
    ADD_PARAM_ERROR(500,"添加商品参数失败"),
    UPDATE_PARAM_ERROR(500,"添加商品参数失败"),
    DELETE_PARAM_ERROR(500,"添加商品参数失败"),
    GOODS_NOT_FOND(404,"商品不存在"),
    GOODS_SAVE_ERROR(500,"新增商品失败"),
    GOODS_DETAIL_NOT_FOND(404,"商品详情不存在"),
    GOODS_SKU_NOT_FOND(404,"商品SKU存在"),
    GOODS_STOCK_NOT_FOND(404,"商品库存不存在"),
    GOODS_UPDATE_ERROR(500,"商品更新失败"),
    GOODS_DELETE_ERROR(500,"商品删除失败"),
    GOODS_ID_CANNOT_BE_NULL(500,"商品ID不能为空"),
    INVALID_USER_DATA_TYPE(400,"用户数据类型无效"),
    INVALID_VERIFU_CODE(400,"验证码无效"),
    INVALID_USRNAME_PASSWORD(400,"用户名或密码错误"),
    CREATE_TOKEN_ERROR(500,"用户凭证生产失败"),
    UNAUTHORIZED(403,"未授权"),
    CART_NOT_FOUND(403,"购物车为空"),
    CREATE_ORDER_ERROR(500,"创建订单失败"),
    STOCK_NOT_ENOUGH(500,"库存不足"),
    ;
    private int code;
    private String msg;
}
