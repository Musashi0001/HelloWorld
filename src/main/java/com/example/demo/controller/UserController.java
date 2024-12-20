package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	UserService userService;

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面のHTML
	 */
	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}
	
	/**
	   * ユーザー情報検索画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  @GetMapping("/user/search")
	  public String displaySearch(Model model) {
	    model.addAttribute("userSearchRequest", new UserSearchRequest());
	    return "user/search";
	  }

	  /**
	   * ユーザー情報検索
	   * @param userSearchRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  @PostMapping("/user/id_search")
	  public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
	    User user = userService.search(userSearchRequest);
	    model.addAttribute("userinfo", user);
	    return "user/search";
	  }
}