package com.meiheyoupin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author vincent
 */
public class RegionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Long value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Long value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Long value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Long value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Long> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Long> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Long value1, Long value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("region_name is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("region_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("region_name =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("region_name <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("region_name >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("region_name >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("region_name <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("region_name <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("region_name like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("region_name not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("region_name in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("region_name not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("region_name between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("region_name not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("region_code is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("region_code is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("region_code =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("region_code <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("region_code >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("region_code >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("region_code <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("region_code <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("region_code like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("region_code not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("region_code in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("region_code not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("region_code between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("region_code not between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdIsNull() {
            addCriterion("parent_region_id is null");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdIsNotNull() {
            addCriterion("parent_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdEqualTo(Long value) {
            addCriterion("parent_region_id =", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdNotEqualTo(Long value) {
            addCriterion("parent_region_id <>", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdGreaterThan(Long value) {
            addCriterion("parent_region_id >", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_region_id >=", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdLessThan(Long value) {
            addCriterion("parent_region_id <", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_region_id <=", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdIn(List<Long> values) {
            addCriterion("parent_region_id in", values, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdNotIn(List<Long> values) {
            addCriterion("parent_region_id not in", values, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdBetween(Long value1, Long value2) {
            addCriterion("parent_region_id between", value1, value2, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_region_id not between", value1, value2, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andLayerIsNull() {
            addCriterion("layer is null");
            return (Criteria) this;
        }

        public Criteria andLayerIsNotNull() {
            addCriterion("layer is not null");
            return (Criteria) this;
        }

        public Criteria andLayerEqualTo(Integer value) {
            addCriterion("layer =", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerNotEqualTo(Integer value) {
            addCriterion("layer <>", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerGreaterThan(Integer value) {
            addCriterion("layer >", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerGreaterThanOrEqualTo(Integer value) {
            addCriterion("layer >=", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerLessThan(Integer value) {
            addCriterion("layer <", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerLessThanOrEqualTo(Integer value) {
            addCriterion("layer <=", value, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerIn(List<Integer> values) {
            addCriterion("layer in", values, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerNotIn(List<Integer> values) {
            addCriterion("layer not in", values, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerBetween(Integer value1, Integer value2) {
            addCriterion("layer between", value1, value2, "layer");
            return (Criteria) this;
        }

        public Criteria andLayerNotBetween(Integer value1, Integer value2) {
            addCriterion("layer not between", value1, value2, "layer");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andZipPhoneIsNull() {
            addCriterion("zip_phone is null");
            return (Criteria) this;
        }

        public Criteria andZipPhoneIsNotNull() {
            addCriterion("zip_phone is not null");
            return (Criteria) this;
        }

        public Criteria andZipPhoneEqualTo(Integer value) {
            addCriterion("zip_phone =", value, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneNotEqualTo(Integer value) {
            addCriterion("zip_phone <>", value, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneGreaterThan(Integer value) {
            addCriterion("zip_phone >", value, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("zip_phone >=", value, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneLessThan(Integer value) {
            addCriterion("zip_phone <", value, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("zip_phone <=", value, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneIn(List<Integer> values) {
            addCriterion("zip_phone in", values, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneNotIn(List<Integer> values) {
            addCriterion("zip_phone not in", values, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneBetween(Integer value1, Integer value2) {
            addCriterion("zip_phone between", value1, value2, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andZipPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("zip_phone not between", value1, value2, "zipPhone");
            return (Criteria) this;
        }

        public Criteria andRegionPostIsNull() {
            addCriterion("region_post is null");
            return (Criteria) this;
        }

        public Criteria andRegionPostIsNotNull() {
            addCriterion("region_post is not null");
            return (Criteria) this;
        }

        public Criteria andRegionPostEqualTo(Integer value) {
            addCriterion("region_post =", value, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostNotEqualTo(Integer value) {
            addCriterion("region_post <>", value, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostGreaterThan(Integer value) {
            addCriterion("region_post >", value, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_post >=", value, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostLessThan(Integer value) {
            addCriterion("region_post <", value, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostLessThanOrEqualTo(Integer value) {
            addCriterion("region_post <=", value, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostIn(List<Integer> values) {
            addCriterion("region_post in", values, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostNotIn(List<Integer> values) {
            addCriterion("region_post not in", values, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostBetween(Integer value1, Integer value2) {
            addCriterion("region_post between", value1, value2, "regionPost");
            return (Criteria) this;
        }

        public Criteria andRegionPostNotBetween(Integer value1, Integer value2) {
            addCriterion("region_post not between", value1, value2, "regionPost");
            return (Criteria) this;
        }

        public Criteria andIsCityIsNull() {
            addCriterion("is_city is null");
            return (Criteria) this;
        }

        public Criteria andIsCityIsNotNull() {
            addCriterion("is_city is not null");
            return (Criteria) this;
        }

        public Criteria andIsCityEqualTo(String value) {
            addCriterion("is_city =", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityNotEqualTo(String value) {
            addCriterion("is_city <>", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityGreaterThan(String value) {
            addCriterion("is_city >", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityGreaterThanOrEqualTo(String value) {
            addCriterion("is_city >=", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityLessThan(String value) {
            addCriterion("is_city <", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityLessThanOrEqualTo(String value) {
            addCriterion("is_city <=", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityLike(String value) {
            addCriterion("is_city like", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityNotLike(String value) {
            addCriterion("is_city not like", value, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityIn(List<String> values) {
            addCriterion("is_city in", values, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityNotIn(List<String> values) {
            addCriterion("is_city not in", values, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityBetween(String value1, String value2) {
            addCriterion("is_city between", value1, value2, "isCity");
            return (Criteria) this;
        }

        public Criteria andIsCityNotBetween(String value1, String value2) {
            addCriterion("is_city not between", value1, value2, "isCity");
            return (Criteria) this;
        }

        public Criteria andRegionMaskIsNull() {
            addCriterion("region_mask is null");
            return (Criteria) this;
        }

        public Criteria andRegionMaskIsNotNull() {
            addCriterion("region_mask is not null");
            return (Criteria) this;
        }

        public Criteria andRegionMaskEqualTo(String value) {
            addCriterion("region_mask =", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskNotEqualTo(String value) {
            addCriterion("region_mask <>", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskGreaterThan(String value) {
            addCriterion("region_mask >", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskGreaterThanOrEqualTo(String value) {
            addCriterion("region_mask >=", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskLessThan(String value) {
            addCriterion("region_mask <", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskLessThanOrEqualTo(String value) {
            addCriterion("region_mask <=", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskLike(String value) {
            addCriterion("region_mask like", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskNotLike(String value) {
            addCriterion("region_mask not like", value, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskIn(List<String> values) {
            addCriterion("region_mask in", values, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskNotIn(List<String> values) {
            addCriterion("region_mask not in", values, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskBetween(String value1, String value2) {
            addCriterion("region_mask between", value1, value2, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionMaskNotBetween(String value1, String value2) {
            addCriterion("region_mask not between", value1, value2, "regionMask");
            return (Criteria) this;
        }

        public Criteria andRegionBannerIsNull() {
            addCriterion("region_banner is null");
            return (Criteria) this;
        }

        public Criteria andRegionBannerIsNotNull() {
            addCriterion("region_banner is not null");
            return (Criteria) this;
        }

        public Criteria andRegionBannerEqualTo(String value) {
            addCriterion("region_banner =", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerNotEqualTo(String value) {
            addCriterion("region_banner <>", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerGreaterThan(String value) {
            addCriterion("region_banner >", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerGreaterThanOrEqualTo(String value) {
            addCriterion("region_banner >=", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerLessThan(String value) {
            addCriterion("region_banner <", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerLessThanOrEqualTo(String value) {
            addCriterion("region_banner <=", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerLike(String value) {
            addCriterion("region_banner like", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerNotLike(String value) {
            addCriterion("region_banner not like", value, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerIn(List<String> values) {
            addCriterion("region_banner in", values, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerNotIn(List<String> values) {
            addCriterion("region_banner not in", values, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerBetween(String value1, String value2) {
            addCriterion("region_banner between", value1, value2, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionBannerNotBetween(String value1, String value2) {
            addCriterion("region_banner not between", value1, value2, "regionBanner");
            return (Criteria) this;
        }

        public Criteria andRegionIconIsNull() {
            addCriterion("region_icon is null");
            return (Criteria) this;
        }

        public Criteria andRegionIconIsNotNull() {
            addCriterion("region_icon is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIconEqualTo(String value) {
            addCriterion("region_icon =", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconNotEqualTo(String value) {
            addCriterion("region_icon <>", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconGreaterThan(String value) {
            addCriterion("region_icon >", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconGreaterThanOrEqualTo(String value) {
            addCriterion("region_icon >=", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconLessThan(String value) {
            addCriterion("region_icon <", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconLessThanOrEqualTo(String value) {
            addCriterion("region_icon <=", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconLike(String value) {
            addCriterion("region_icon like", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconNotLike(String value) {
            addCriterion("region_icon not like", value, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconIn(List<String> values) {
            addCriterion("region_icon in", values, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconNotIn(List<String> values) {
            addCriterion("region_icon not in", values, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconBetween(String value1, String value2) {
            addCriterion("region_icon between", value1, value2, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionIconNotBetween(String value1, String value2) {
            addCriterion("region_icon not between", value1, value2, "regionIcon");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldIsNull() {
            addCriterion("region_banner_old is null");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldIsNotNull() {
            addCriterion("region_banner_old is not null");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldEqualTo(String value) {
            addCriterion("region_banner_old =", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldNotEqualTo(String value) {
            addCriterion("region_banner_old <>", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldGreaterThan(String value) {
            addCriterion("region_banner_old >", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldGreaterThanOrEqualTo(String value) {
            addCriterion("region_banner_old >=", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldLessThan(String value) {
            addCriterion("region_banner_old <", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldLessThanOrEqualTo(String value) {
            addCriterion("region_banner_old <=", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldLike(String value) {
            addCriterion("region_banner_old like", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldNotLike(String value) {
            addCriterion("region_banner_old not like", value, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldIn(List<String> values) {
            addCriterion("region_banner_old in", values, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldNotIn(List<String> values) {
            addCriterion("region_banner_old not in", values, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldBetween(String value1, String value2) {
            addCriterion("region_banner_old between", value1, value2, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionBannerOldNotBetween(String value1, String value2) {
            addCriterion("region_banner_old not between", value1, value2, "regionBannerOld");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalIsNull() {
            addCriterion("region_online_total is null");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalIsNotNull() {
            addCriterion("region_online_total is not null");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalEqualTo(Integer value) {
            addCriterion("region_online_total =", value, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalNotEqualTo(Integer value) {
            addCriterion("region_online_total <>", value, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalGreaterThan(Integer value) {
            addCriterion("region_online_total >", value, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_online_total >=", value, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalLessThan(Integer value) {
            addCriterion("region_online_total <", value, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalLessThanOrEqualTo(Integer value) {
            addCriterion("region_online_total <=", value, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalIn(List<Integer> values) {
            addCriterion("region_online_total in", values, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalNotIn(List<Integer> values) {
            addCriterion("region_online_total not in", values, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalBetween(Integer value1, Integer value2) {
            addCriterion("region_online_total between", value1, value2, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("region_online_total not between", value1, value2, "regionOnlineTotal");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayIsNull() {
            addCriterion("region_online_today is null");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayIsNotNull() {
            addCriterion("region_online_today is not null");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayEqualTo(Integer value) {
            addCriterion("region_online_today =", value, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayNotEqualTo(Integer value) {
            addCriterion("region_online_today <>", value, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayGreaterThan(Integer value) {
            addCriterion("region_online_today >", value, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_online_today >=", value, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayLessThan(Integer value) {
            addCriterion("region_online_today <", value, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayLessThanOrEqualTo(Integer value) {
            addCriterion("region_online_today <=", value, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayIn(List<Integer> values) {
            addCriterion("region_online_today in", values, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayNotIn(List<Integer> values) {
            addCriterion("region_online_today not in", values, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayBetween(Integer value1, Integer value2) {
            addCriterion("region_online_today between", value1, value2, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineTodayNotBetween(Integer value1, Integer value2) {
            addCriterion("region_online_today not between", value1, value2, "regionOnlineToday");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateIsNull() {
            addCriterion("region_online_date is null");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateIsNotNull() {
            addCriterion("region_online_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateEqualTo(Date value) {
            addCriterion("region_online_date =", value, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateNotEqualTo(Date value) {
            addCriterion("region_online_date <>", value, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateGreaterThan(Date value) {
            addCriterion("region_online_date >", value, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateGreaterThanOrEqualTo(Date value) {
            addCriterion("region_online_date >=", value, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateLessThan(Date value) {
            addCriterion("region_online_date <", value, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateLessThanOrEqualTo(Date value) {
            addCriterion("region_online_date <=", value, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateIn(List<Date> values) {
            addCriterion("region_online_date in", values, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateNotIn(List<Date> values) {
            addCriterion("region_online_date not in", values, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateBetween(Date value1, Date value2) {
            addCriterion("region_online_date between", value1, value2, "regionOnlineDate");
            return (Criteria) this;
        }

        public Criteria andRegionOnlineDateNotBetween(Date value1, Date value2) {
            addCriterion("region_online_date not between", value1, value2, "regionOnlineDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}