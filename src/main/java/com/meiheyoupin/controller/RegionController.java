package com.meiheyoupin.controller;

import com.alibaba.fastjson.JSONObject;
import com.meiheyoupin.common.CommonUtil;
import com.meiheyoupin.common.ConvertUtil;
import com.meiheyoupin.common.controller.BaseController;
import com.meiheyoupin.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
public class RegionController extends BaseController {

    @Autowired
    RegionService regionService;

    @RequestMapping("getChildRegionListInSite")
    public void getChildRegionListInSite(HttpServletRequest request, HttpServletResponse response, Model model) {
        int regionId = CommonUtil.getIntFromString(CommonUtil.GetRequestParam(request, "regionId", "0"));
        JSONObject res = new JSONObject();

        try {
            HashMap e = new HashMap();
            e.put("regionId", Integer.valueOf(regionId));
            List ret =  regionService.getChildRegionList(e);
            ConvertUtil.convertDataBaseMapToJavaMap(ret);
            res.put("state", Integer.valueOf(1));
            res.put("regionList", ret);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        this.echoJSON(response, res);
    }
}
