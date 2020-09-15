package cn.itcast.service.impl;

import cn.itcast.dao.GoodsDao;
import cn.itcast.dao.SaleDao;
import cn.itcast.domain.Goods;
import cn.itcast.domain.Sale;
import cn.itcast.execep.NotEnoughException;
import cn.itcast.service.BuyGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyGoodsServiceImpl implements BuyGoodsService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private SaleDao saleDao;
/*	@Transactional(
			propagation = Propagation.REQUIRED,
			isolation = Isolation.DEFAULT,
			rollbackFor = {NullPointerException.class,NotEnoughException.class}
	)*/
	@Transactional
	@Override
	public void buy(String goodsId,String nums) {
		//为了测试事务,更换了 sale表和goods表的逻辑顺序

		//更新sale表
		Sale sale = new Sale();
		sale.setGid(goodsId);
		sale.setNums(nums);
		saleDao.insertSale(sale);

		//更新goods表
		Goods goods = goodsDao.selectGoods(goodsId);
		if (goods==null){
			throw new NullPointerException("编号为:"+goodsId+",商品不存在");
		}else if (Integer.parseInt(goods.getAmount())<Integer.parseInt(nums)){
			throw new NotEnoughException("编号为:"+goodsId+",的商品不足");
		}
		Goods goods1 = new Goods();
		goods1.setAmount(nums);
		goods1.setId(goodsId);
		goodsDao.updateGoods(goods1);
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}
}
