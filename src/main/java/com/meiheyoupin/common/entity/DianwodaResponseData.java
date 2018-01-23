package com.meiheyoupin.common.entity;


import java.util.List;

public class DianwodaResponseData {
    private String errorCode;
    private String message;
    private boolean success;
    private result result;

    public DianwodaResponseData() {
    }

    public DianwodaResponseData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DianwodaResponseData.result getResult() {
        return result;
    }

    public void setResult(DianwodaResponseData.result result) {
        this.result = result;
    }

    public class result {
        private String dwdOrderId;
        private String skycon;
        private String price;
        private Integer distance;

        private String orderOriginalId;
        private Integer orderStatus;
        private Long timeStatusUpdate;
        private String abnormalReason;
        private String riderCode;
        private String riderName;
        private String riderMobile;
        private Double riderLat;
        private Double riderLng;
        private Long timePositionUpdate;
        private Long timeEstimatedPickup;
        private Long time_estimated_delivered;
        private String amName;
        private String amMobile;
        private List<LogisticInfo> logisticInfo;

        public String getDwdOrderId() {
            return dwdOrderId;
        }

        public void setDwdOrderId(String dwdOrderId) {
            this.dwdOrderId = dwdOrderId;
        }

        public String getSkycon() {
            return skycon;
        }

        public void setSkycon(String skycon) {
            this.skycon = skycon;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public String getOrderOriginalId() {
            return orderOriginalId;
        }

        public void setOrderOriginalId(String orderOriginalId) {
            this.orderOriginalId = orderOriginalId;
        }

        public Integer getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(Integer orderStatus) {
            this.orderStatus = orderStatus;
        }

        public Long getTimeStatusUpdate() {
            return timeStatusUpdate;
        }

        public void setTimeStatusUpdate(Long timeStatusUpdate) {
            this.timeStatusUpdate = timeStatusUpdate;
        }

        public String getAbnormalReason() {
            return abnormalReason;
        }

        public void setAbnormalReason(String abnormalReason) {
            this.abnormalReason = abnormalReason;
        }

        public String getRiderCode() {
            return riderCode;
        }

        public void setRiderCode(String riderCode) {
            this.riderCode = riderCode;
        }

        public String getRiderName() {
            return riderName;
        }

        public void setRiderName(String riderName) {
            this.riderName = riderName;
        }

        public String getRiderMobile() {
            return riderMobile;
        }

        public void setRiderMobile(String riderMobile) {
            this.riderMobile = riderMobile;
        }

        public Double getRiderLat() {
            return riderLat;
        }

        public void setRiderLat(Double riderLat) {
            this.riderLat = riderLat;
        }

        public Double getRiderLng() {
            return riderLng;
        }

        public void setRiderLng(Double riderLng) {
            this.riderLng = riderLng;
        }

        public Long getTimePositionUpdate() {
            return timePositionUpdate;
        }

        public void setTimePositionUpdate(Long timePositionUpdate) {
            this.timePositionUpdate = timePositionUpdate;
        }

        public Long getTimeEstimatedPickup() {
            return timeEstimatedPickup;
        }

        public void setTimeEstimatedPickup(Long timeEstimatedPickup) {
            this.timeEstimatedPickup = timeEstimatedPickup;
        }

        public Long getTime_estimated_delivered() {
            return time_estimated_delivered;
        }

        public void setTime_estimated_delivered(Long time_estimated_delivered) {
            this.time_estimated_delivered = time_estimated_delivered;
        }

        public String getAmName() {
            return amName;
        }

        public void setAmName(String amName) {
            this.amName = amName;
        }

        public String getAmMobile() {
            return amMobile;
        }

        public void setAmMobile(String amMobile) {
            this.amMobile = amMobile;
        }

        public List<LogisticInfo> getLogisticInfo() {
            return logisticInfo;
        }

        public void setLogisticInfo(List<LogisticInfo> logisticInfo) {
            this.logisticInfo = logisticInfo;
        }

        @Override
        public String toString() {
            return "result{" +
                    "dwdOrderId='" + dwdOrderId + '\'' +
                    ", skycon='" + skycon + '\'' +
                    ", price='" + price + '\'' +
                    ", distance=" + distance +
                    ", orderOriginalId='" + orderOriginalId + '\'' +
                    ", orderStatus=" + orderStatus +
                    ", timeStatusUpdate=" + timeStatusUpdate +
                    ", abnormalReason='" + abnormalReason + '\'' +
                    ", riderCode='" + riderCode + '\'' +
                    ", riderName='" + riderName + '\'' +
                    ", riderMobile='" + riderMobile + '\'' +
                    ", riderLat=" + riderLat +
                    ", riderLng=" + riderLng +
                    ", timePositionUpdate=" + timePositionUpdate +
                    ", timeEstimatedPickup=" + timeEstimatedPickup +
                    ", time_estimated_delivered=" + time_estimated_delivered +
                    ", amName='" + amName + '\'' +
                    ", amMobile='" + amMobile + '\'' +
                    ", logisticInfo=" + logisticInfo +
                    '}';
        }

        public class LogisticInfo {

            private Integer orderStatus;
            private Long timeStatusUpdate;

            public Integer getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(Integer orderStatus) {
                this.orderStatus = orderStatus;
            }

            public Long getTimeStatusUpdate() {
                return timeStatusUpdate;
            }

            public void setTimeStatusUpdate(Long timeStatusUpdate) {
                this.timeStatusUpdate = timeStatusUpdate;
            }

            @Override
            public String toString() {
                return "LogisticInfo{" +
                        "orderStatus=" + orderStatus +
                        ", timeStatusUpdate=" + timeStatusUpdate +
                        '}';
            }
        }

    }

    @Override
    public String toString() {
        return "DianwodaResponseData{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", result=" + result +
                '}';
    }
}
