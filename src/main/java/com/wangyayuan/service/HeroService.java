package com.wangyayuan.service;

import java.util.List;
import java.util.Map;

import com.wangyayuan.beans.Ziwei;
import com.wangyayuan.beans.Hero;

public interface HeroService {
	//列表
	public List<Hero> queryAll(Map<String,Object> map);

	public List<Ziwei> queryCamp();

	public void addHero(Hero hero);

	public Hero queryHeroById(Integer id);

	public void updateIsHave(Integer id);
	
}
