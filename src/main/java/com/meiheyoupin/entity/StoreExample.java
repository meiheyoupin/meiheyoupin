package com.meiheyoupin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author vincent
 */
public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNull() {
            addCriterion("invitation_code is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNotNull() {
            addCriterion("invitation_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeEqualTo(String value) {
            addCriterion("invitation_code =", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotEqualTo(String value) {
            addCriterion("invitation_code <>", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThan(String value) {
            addCriterion("invitation_code >", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_code >=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThan(String value) {
            addCriterion("invitation_code <", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThanOrEqualTo(String value) {
            addCriterion("invitation_code <=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLike(String value) {
            addCriterion("invitation_code like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotLike(String value) {
            addCriterion("invitation_code not like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIn(List<String> values) {
            addCriterion("invitation_code in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotIn(List<String> values) {
            addCriterion("invitation_code not in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeBetween(String value1, String value2) {
            addCriterion("invitation_code between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotBetween(String value1, String value2) {
            addCriterion("invitation_code not between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreAddrIsNull() {
            addCriterion("store_addr is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddrIsNotNull() {
            addCriterion("store_addr is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddrEqualTo(String value) {
            addCriterion("store_addr =", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrNotEqualTo(String value) {
            addCriterion("store_addr <>", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrGreaterThan(String value) {
            addCriterion("store_addr >", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrGreaterThanOrEqualTo(String value) {
            addCriterion("store_addr >=", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrLessThan(String value) {
            addCriterion("store_addr <", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrLessThanOrEqualTo(String value) {
            addCriterion("store_addr <=", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrLike(String value) {
            addCriterion("store_addr like", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrNotLike(String value) {
            addCriterion("store_addr not like", value, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrIn(List<String> values) {
            addCriterion("store_addr in", values, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrNotIn(List<String> values) {
            addCriterion("store_addr not in", values, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrBetween(String value1, String value2) {
            addCriterion("store_addr between", value1, value2, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andStoreAddrNotBetween(String value1, String value2) {
            addCriterion("store_addr not between", value1, value2, "storeAddr");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNull() {
            addCriterion("boss_name is null");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNotNull() {
            addCriterion("boss_name is not null");
            return (Criteria) this;
        }

        public Criteria andBossNameEqualTo(String value) {
            addCriterion("boss_name =", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotEqualTo(String value) {
            addCriterion("boss_name <>", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThan(String value) {
            addCriterion("boss_name >", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThanOrEqualTo(String value) {
            addCriterion("boss_name >=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThan(String value) {
            addCriterion("boss_name <", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThanOrEqualTo(String value) {
            addCriterion("boss_name <=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLike(String value) {
            addCriterion("boss_name like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotLike(String value) {
            addCriterion("boss_name not like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameIn(List<String> values) {
            addCriterion("boss_name in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotIn(List<String> values) {
            addCriterion("boss_name not in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameBetween(String value1, String value2) {
            addCriterion("boss_name between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotBetween(String value1, String value2) {
            addCriterion("boss_name not between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossGenderIsNull() {
            addCriterion("boss_gender is null");
            return (Criteria) this;
        }

        public Criteria andBossGenderIsNotNull() {
            addCriterion("boss_gender is not null");
            return (Criteria) this;
        }

        public Criteria andBossGenderEqualTo(Byte value) {
            addCriterion("boss_gender =", value, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderNotEqualTo(Byte value) {
            addCriterion("boss_gender <>", value, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderGreaterThan(Byte value) {
            addCriterion("boss_gender >", value, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("boss_gender >=", value, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderLessThan(Byte value) {
            addCriterion("boss_gender <", value, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderLessThanOrEqualTo(Byte value) {
            addCriterion("boss_gender <=", value, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderIn(List<Byte> values) {
            addCriterion("boss_gender in", values, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderNotIn(List<Byte> values) {
            addCriterion("boss_gender not in", values, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderBetween(Byte value1, Byte value2) {
            addCriterion("boss_gender between", value1, value2, "bossGender");
            return (Criteria) this;
        }

        public Criteria andBossGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("boss_gender not between", value1, value2, "bossGender");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNull() {
            addCriterion("avatar_url is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNotNull() {
            addCriterion("avatar_url is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlEqualTo(String value) {
            addCriterion("avatar_url =", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotEqualTo(String value) {
            addCriterion("avatar_url <>", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThan(String value) {
            addCriterion("avatar_url >", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_url >=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThan(String value) {
            addCriterion("avatar_url <", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThanOrEqualTo(String value) {
            addCriterion("avatar_url <=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLike(String value) {
            addCriterion("avatar_url like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotLike(String value) {
            addCriterion("avatar_url not like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIn(List<String> values) {
            addCriterion("avatar_url in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotIn(List<String> values) {
            addCriterion("avatar_url not in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlBetween(String value1, String value2) {
            addCriterion("avatar_url between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotBetween(String value1, String value2) {
            addCriterion("avatar_url not between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlIsNull() {
            addCriterion("store_outside_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlIsNotNull() {
            addCriterion("store_outside_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlEqualTo(String value) {
            addCriterion("store_outside_photo_url =", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlNotEqualTo(String value) {
            addCriterion("store_outside_photo_url <>", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlGreaterThan(String value) {
            addCriterion("store_outside_photo_url >", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_outside_photo_url >=", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlLessThan(String value) {
            addCriterion("store_outside_photo_url <", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("store_outside_photo_url <=", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlLike(String value) {
            addCriterion("store_outside_photo_url like", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlNotLike(String value) {
            addCriterion("store_outside_photo_url not like", value, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlIn(List<String> values) {
            addCriterion("store_outside_photo_url in", values, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlNotIn(List<String> values) {
            addCriterion("store_outside_photo_url not in", values, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlBetween(String value1, String value2) {
            addCriterion("store_outside_photo_url between", value1, value2, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreOutsidePhotoUrlNotBetween(String value1, String value2) {
            addCriterion("store_outside_photo_url not between", value1, value2, "storeOutsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlIsNull() {
            addCriterion("store_inside_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlIsNotNull() {
            addCriterion("store_inside_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlEqualTo(String value) {
            addCriterion("store_inside_photo_url =", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlNotEqualTo(String value) {
            addCriterion("store_inside_photo_url <>", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlGreaterThan(String value) {
            addCriterion("store_inside_photo_url >", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_inside_photo_url >=", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlLessThan(String value) {
            addCriterion("store_inside_photo_url <", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("store_inside_photo_url <=", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlLike(String value) {
            addCriterion("store_inside_photo_url like", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlNotLike(String value) {
            addCriterion("store_inside_photo_url not like", value, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlIn(List<String> values) {
            addCriterion("store_inside_photo_url in", values, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlNotIn(List<String> values) {
            addCriterion("store_inside_photo_url not in", values, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlBetween(String value1, String value2) {
            addCriterion("store_inside_photo_url between", value1, value2, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreInsidePhotoUrlNotBetween(String value1, String value2) {
            addCriterion("store_inside_photo_url not between", value1, value2, "storeInsidePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlIsNull() {
            addCriterion("boss_idcard_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlIsNotNull() {
            addCriterion("boss_idcard_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlEqualTo(String value) {
            addCriterion("boss_idcard_photo_url =", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlNotEqualTo(String value) {
            addCriterion("boss_idcard_photo_url <>", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlGreaterThan(String value) {
            addCriterion("boss_idcard_photo_url >", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("boss_idcard_photo_url >=", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlLessThan(String value) {
            addCriterion("boss_idcard_photo_url <", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("boss_idcard_photo_url <=", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlLike(String value) {
            addCriterion("boss_idcard_photo_url like", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlNotLike(String value) {
            addCriterion("boss_idcard_photo_url not like", value, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlIn(List<String> values) {
            addCriterion("boss_idcard_photo_url in", values, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlNotIn(List<String> values) {
            addCriterion("boss_idcard_photo_url not in", values, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlBetween(String value1, String value2) {
            addCriterion("boss_idcard_photo_url between", value1, value2, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andBossIdcardPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("boss_idcard_photo_url not between", value1, value2, "bossIdcardPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlIsNull() {
            addCriterion("certificate_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlIsNotNull() {
            addCriterion("certificate_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlEqualTo(String value) {
            addCriterion("certificate_photo_url =", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlNotEqualTo(String value) {
            addCriterion("certificate_photo_url <>", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlGreaterThan(String value) {
            addCriterion("certificate_photo_url >", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_photo_url >=", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlLessThan(String value) {
            addCriterion("certificate_photo_url <", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("certificate_photo_url <=", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlLike(String value) {
            addCriterion("certificate_photo_url like", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlNotLike(String value) {
            addCriterion("certificate_photo_url not like", value, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlIn(List<String> values) {
            addCriterion("certificate_photo_url in", values, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlNotIn(List<String> values) {
            addCriterion("certificate_photo_url not in", values, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlBetween(String value1, String value2) {
            addCriterion("certificate_photo_url between", value1, value2, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificatePhotoUrlNotBetween(String value1, String value2) {
            addCriterion("certificate_photo_url not between", value1, value2, "certificatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlIsNull() {
            addCriterion("store_licence_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlIsNotNull() {
            addCriterion("store_licence_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlEqualTo(String value) {
            addCriterion("store_licence_photo_url =", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlNotEqualTo(String value) {
            addCriterion("store_licence_photo_url <>", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlGreaterThan(String value) {
            addCriterion("store_licence_photo_url >", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("store_licence_photo_url >=", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlLessThan(String value) {
            addCriterion("store_licence_photo_url <", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("store_licence_photo_url <=", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlLike(String value) {
            addCriterion("store_licence_photo_url like", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlNotLike(String value) {
            addCriterion("store_licence_photo_url not like", value, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlIn(List<String> values) {
            addCriterion("store_licence_photo_url in", values, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlNotIn(List<String> values) {
            addCriterion("store_licence_photo_url not in", values, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlBetween(String value1, String value2) {
            addCriterion("store_licence_photo_url between", value1, value2, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andStoreLicencePhotoUrlNotBetween(String value1, String value2) {
            addCriterion("store_licence_photo_url not between", value1, value2, "storeLicencePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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