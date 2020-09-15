package cn.itcast.dao;

import cn.itcast.domain.Goods;


public interface GoodsDao {

	//更新商品信息
	int updateGoods(Goods goods);
	//查询商品信息
	Goods selectGoods(String id);

}
