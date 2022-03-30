class OffersAndDiscount {
    private String couponCode = "TEN10";
    private double discoutPercentage = 0.1;
    private String appliedCouponCode = "";

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getDiscountPercentage() {
        return discoutPercentage;
    }

    public void setDiscountPercentage(double discoutPercentage) {
        this.discoutPercentage = discoutPercentage;
    }

    public String getAppliedCouponCode() {
        return appliedCouponCode;
    }

    public void setAppliedCouponCode(String appliedCouponCode) {
        this.appliedCouponCode = appliedCouponCode;
    }
    
}
