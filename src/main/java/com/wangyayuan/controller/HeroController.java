package com.wangyayuan.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyayuan.beans.Ziwei;
import com.wangyayuan.beans.Hero;
import com.wangyayuan.service.HeroService;
import com.wangyayuan.utils.FileUtils;

@Controller
public class HeroController {
	
	@Resource
	private HeroService heroService;

	
	@RequestMapping("queryAll")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,Model model,Integer cid,Integer yis,Double startPrice,Double endPrice){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("yis", yis);
		map.put("startPrice", startPrice);
		map.put("endPrice", endPrice);
		
		//鍒嗛〉宸ュ叿绫籔ageHelper
		PageHelper.startPage(pageNum,3);
		List<Hero> list = heroService.queryAll(map);	
		PageInfo<Hero> plist = new PageInfo<>(list);
		model.addAttribute("plist", plist);
		
		//鏌ヨ鎵�鏈夌殑鑻遍泟闃佃惀
		List<Ziwei> campList = heroService.queryCamp();
		model.addAttribute("campList", campList);
		
		
		//妯＄硦鍖洪棿鍥炴樉
		model.addAttribute("map", map);
		
		return "list";
	}
	
	@RequestMapping("queryCamp")
	@ResponseBody
	public List<Ziwei> queryCamp(){
		//鏌ヨ鎵�鏈夌殑鑻遍泟闃佃惀
		List<Ziwei> campList = heroService.queryCamp();
		return campList;
	}
	
	
	@RequestMapping("add")
	public String add(Hero hero,MultipartFile file) throws IllegalStateException, IOException{
		
		try {
			//涓婁紶 杩斿洖鍥剧墖璺緞
			String upload = FileUtils.upload(file);
			
			hero.setYtp(upload);
			
			heroService.addHero(hero);
			return "redirect:queryAll";
		} catch (Exception e) {
			return "add";
		}
		
	}
	
	
	@RequestMapping("lookImg")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	
	@RequestMapping("queryHeroById")
	public String queryHeroById(Integer id,Model model){
		Hero hero = heroService.queryHeroById(id);
		model.addAttribute("hero", hero);
		return "show";
	}
	
	@RequestMapping("updateIsHave")
	@ResponseBody
	public boolean updateIsHave(Integer id){
		
		try {
			heroService.updateIsHave(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}
