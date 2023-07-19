package com.bawangbai.elastic.search.util;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

public class EsPageInfoUtils {

    /**
     * @param data
     * @param current
     * @param pageSize
     * @param total
     * @param <T>
     * @return
     */
    public static <T> Page<T> esPageToDbPage(Integer current, Integer pageSize, Long total, List<T> data) {
        Page<T> page = new Page(current, pageSize);
        page.setCurrent(current);
        page.setTotal(total);
        page.setPages(total % pageSize == 0 ? total / 10 : (total / 10 + 1));
        page.setRecords(CollectionUtil.isEmpty(data) ? new ArrayList<>() : data);
        return page;
    }

}