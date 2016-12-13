/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2016/11/13 ��Ԫ at 19:54:25 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsOrder</p>
 *
 * <p>Description: Domain Object describing a BnsOrder entity</p>
 *
 */
@Entity (name="BnsOrder")
@Table (name="bns_order")
@NamedQueries({
	 @NamedQuery(name="BnsOrder.findAll", query="SELECT bnsorder FROM BnsOrder bnsorder")
	,@NamedQuery(name="BnsOrder.findByCode", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.code = :code")
	,@NamedQuery(name="BnsOrder.findByCodeContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.code like :code")

	,@NamedQuery(name="BnsOrder.findByCity", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.city = :city")
	,@NamedQuery(name="BnsOrder.findByCityContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.city like :city")

	,@NamedQuery(name="BnsOrder.findByTakeTime", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.takeTime = :takeTime")

	,@NamedQuery(name="BnsOrder.findByCreatedUser", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdUser = :createdUser")
	,@NamedQuery(name="BnsOrder.findByCreatedUserContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdUser like :createdUser")

	,@NamedQuery(name="BnsOrder.findByCustomer", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.customer = :customer")
	,@NamedQuery(name="BnsOrder.findByCustomerContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.customer like :customer")

	,@NamedQuery(name="BnsOrder.findByIdcard", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.idcard = :idcard")
	,@NamedQuery(name="BnsOrder.findByIdcardContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.idcard like :idcard")

	,@NamedQuery(name="BnsOrder.findByMobile", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.mobile = :mobile")
	,@NamedQuery(name="BnsOrder.findByMobileContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.mobile like :mobile")

	,@NamedQuery(name="BnsOrder.findByPeople", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.people = :people")

	,@NamedQuery(name="BnsOrder.findByCloth", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.cloth = :cloth")
	,@NamedQuery(name="BnsOrder.findByClothContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.cloth like :cloth")

	,@NamedQuery(name="BnsOrder.findBySite", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.site = :site")
	,@NamedQuery(name="BnsOrder.findBySiteContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.site like :site")

	,@NamedQuery(name="BnsOrder.findByHotel", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.hotel = :hotel")
	,@NamedQuery(name="BnsOrder.findByHotelContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.hotel like :hotel")

	,@NamedQuery(name="BnsOrder.findByMoney", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.money = :money")

	,@NamedQuery(name="BnsOrder.findByPayment", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.payment = :payment")
	,@NamedQuery(name="BnsOrder.findByPaymentContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.payment like :payment")

	,@NamedQuery(name="BnsOrder.findByPickup", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.pickup = :pickup")

	,@NamedQuery(name="BnsOrder.findByState", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.state = :state")

	,@NamedQuery(name="BnsOrder.findByAcceptUser", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.acceptUser = :acceptUser")
	,@NamedQuery(name="BnsOrder.findByAcceptUserContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.acceptUser like :acceptUser")

	,@NamedQuery(name="BnsOrder.findByImgs", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.imgs = :imgs")
	,@NamedQuery(name="BnsOrder.findByImgsContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.imgs like :imgs")

	,@NamedQuery(name="BnsOrder.findByRemark", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.remark = :remark")
	,@NamedQuery(name="BnsOrder.findByRemarkContaining", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.remark like :remark")

	,@NamedQuery(name="BnsOrder.findByCreatedTime", query="SELECT bnsorder FROM BnsOrder bnsorder WHERE bnsorder.createdTime = :createdTime")

})

public class BnsOrder implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_PEOPLE = Integer.valueOf(0);
	public static final java.math.BigDecimal __DEFAULT_MONEY = java.math.BigDecimal.valueOf(0.00);
	public static final Integer __DEFAULT_PICKUP = Integer.valueOf(0);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsOrder.findAll";
    public static final String FIND_BY_CODE = "BnsOrder.findByCode";
    public static final String FIND_BY_CODE_CONTAINING ="BnsOrder.findByCodeContaining";
    public static final String FIND_BY_CITY = "BnsOrder.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="BnsOrder.findByCityContaining";
    public static final String FIND_BY_TAKETIME = "BnsOrder.findByTakeTime";
    public static final String FIND_BY_CREATEDUSER = "BnsOrder.findByCreatedUser";
    public static final String FIND_BY_CREATEDUSER_CONTAINING ="BnsOrder.findByCreatedUserContaining";
    public static final String FIND_BY_CUSTOMER = "BnsOrder.findByCustomer";
    public static final String FIND_BY_CUSTOMER_CONTAINING ="BnsOrder.findByCustomerContaining";
    public static final String FIND_BY_IDCARD = "BnsOrder.findByIdcard";
    public static final String FIND_BY_IDCARD_CONTAINING ="BnsOrder.findByIdcardContaining";
    public static final String FIND_BY_MOBILE = "BnsOrder.findByMobile";
    public static final String FIND_BY_MOBILE_CONTAINING ="BnsOrder.findByMobileContaining";
    public static final String FIND_BY_PEOPLE = "BnsOrder.findByPeople";
    public static final String FIND_BY_CLOTH = "BnsOrder.findByCloth";
    public static final String FIND_BY_CLOTH_CONTAINING ="BnsOrder.findByClothContaining";
    public static final String FIND_BY_SITE = "BnsOrder.findBySite";
    public static final String FIND_BY_SITE_CONTAINING ="BnsOrder.findBySiteContaining";
    public static final String FIND_BY_HOTEL = "BnsOrder.findByHotel";
    public static final String FIND_BY_HOTEL_CONTAINING ="BnsOrder.findByHotelContaining";
    public static final String FIND_BY_MONEY = "BnsOrder.findByMoney";
    public static final String FIND_BY_PAYMENT = "BnsOrder.findByPayment";
    public static final String FIND_BY_PAYMENT_CONTAINING ="BnsOrder.findByPaymentContaining";
    public static final String FIND_BY_PICKUP = "BnsOrder.findByPickup";
    public static final String FIND_BY_STATE = "BnsOrder.findByState";
    public static final String FIND_BY_ACCEPTUSER = "BnsOrder.findByAcceptUser";
    public static final String FIND_BY_ACCEPTUSER_CONTAINING ="BnsOrder.findByAcceptUserContaining";
    public static final String FIND_BY_IMGS = "BnsOrder.findByImgs";
    public static final String FIND_BY_IMGS_CONTAINING ="BnsOrder.findByImgsContaining";
    public static final String FIND_BY_REMARK = "BnsOrder.findByRemark";
    public static final String FIND_BY_REMARK_CONTAINING ="BnsOrder.findByRemarkContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsOrder.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @code-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @code-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-code@
    @Column(name="code"  , length=30 , nullable=true , unique=false)
    private String code; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @city-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @city-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-city@
    @Column(name="city"  , length=64 , nullable=true , unique=false)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @take_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @take_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-take_time@
    @Column(name="take_time"   , nullable=true , unique=false)
    private Timestamp takeTime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_user@
    @Column(name="created_user"  , length=64 , nullable=true , unique=false)
    private String createdUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @customer-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @customer-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-customer@
    @Column(name="customer"  , length=30 , nullable=true , unique=false)
    private String customer; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @idcard-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @idcard-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-idcard@
    @Column(name="idcard"  , length=18 , nullable=true , unique=false)
    private String idcard; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @mobile-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @mobile-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-mobile@
    @Column(name="mobile"  , length=11 , nullable=true , unique=false)
    private String mobile; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @people-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @people-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-people@
    @Column(name="people"   , nullable=true , unique=false)
    private Integer people; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @cloth-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @cloth-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-cloth@
    @Column(name="cloth"   , nullable=true , unique=false)
    private String cloth; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @site-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @site-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-site@
    @Column(name="site"   , nullable=true , unique=false)
    private String site; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @hotel-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @hotel-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hotel@
    @Column(name="hotel"   , nullable=true , unique=false)
    private String hotel; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-money@
    @Column(name="money"   , nullable=true , unique=false)
    private java.math.BigDecimal money; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @payment-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @payment-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-payment@
    @Column(name="payment"  , length=20 , nullable=true , unique=false)
    private String payment; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @pickup-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @pickup-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-pickup@
    @Column(name="pickup"   , nullable=true , unique=false)
    private Integer pickup; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @accept_user-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @accept_user-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-accept_user@
    @Column(name="accept_user"  , length=64 , nullable=true , unique=false)
    private String acceptUser; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @imgs-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @imgs-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-imgs@
    @Column(name="imgs"   , nullable=true , unique=false)
    private String imgs; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @remark-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @remark-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-remark@
    @Column(name="remark"  , length=255 , nullable=true , unique=false)
    private String remark; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_time@
    @Column(name="created_time"   , nullable=true , unique=false)
    private Timestamp createdTime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public BnsOrder() {
    }

	/**
	* All field constructor 
	*/
    public BnsOrder(
       String id,
       String code,
       String city,
       Timestamp takeTime,
       String createdUser,
       String customer,
       String idcard,
       String mobile,
       Integer people,
       String cloth,
       String site,
       String hotel,
       java.math.BigDecimal money,
       String payment,
       Integer pickup,
       Integer state,
       String acceptUser,
       String imgs,
       String remark,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCode (code);
       setCity (city);
       setTakeTime (takeTime);
       setCreatedUser (createdUser);
       setCustomer (customer);
       setIdcard (idcard);
       setMobile (mobile);
       setPeople (people);
       setCloth (cloth);
       setSite (site);
       setHotel (hotel);
       setMoney (money);
       setPayment (payment);
       setPickup (pickup);
       setState (state);
       setAcceptUser (acceptUser);
       setImgs (imgs);
       setRemark (remark);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsOrder flat() {
	   return new BnsOrder(
          getId(),
          getCode(),
          getCity(),
          getTakeTime(),
          getCreatedUser(),
          getCustomer(),
          getIdcard(),
          getMobile(),
          getPeople(),
          getCloth(),
          getSite(),
          getHotel(),
          getMoney(),
          getPayment(),
          getPickup(),
          getState(),
          getAcceptUser(),
          getImgs(),
          getRemark(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-code@
    public String getCode() {
        return code;
    }
	
    public void setCode (String code) {
        this.code =  code;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-city@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-take_time@
    public Timestamp getTakeTime() {
        return takeTime;
    }
	
    public void setTakeTime (Timestamp takeTime) {
        this.takeTime =  takeTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_user@
    public String getCreatedUser() {
        return createdUser;
    }
	
    public void setCreatedUser (String createdUser) {
        this.createdUser =  createdUser;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-customer@
    public String getCustomer() {
        return customer;
    }
	
    public void setCustomer (String customer) {
        this.customer =  customer;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-idcard@
    public String getIdcard() {
        return idcard;
    }
	
    public void setIdcard (String idcard) {
        this.idcard =  idcard;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-mobile@
    public String getMobile() {
        return mobile;
    }
	
    public void setMobile (String mobile) {
        this.mobile =  mobile;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-people@
    public Integer getPeople() {
        return people;
    }
	
    public void setPeople (Integer people) {
        this.people =  people;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-cloth@
    public String getCloth() {
        return cloth;
    }
	
    public void setCloth (String cloth) {
        this.cloth =  cloth;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-site@
    public String getSite() {
        return site;
    }
	
    public void setSite (String site) {
        this.site =  site;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-hotel@
    public String getHotel() {
        return hotel;
    }
	
    public void setHotel (String hotel) {
        this.hotel =  hotel;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-money@
    public java.math.BigDecimal getMoney() {
        return money;
    }
	
    public void setMoney (java.math.BigDecimal money) {
        this.money =  money;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-payment@
    public String getPayment() {
        return payment;
    }
	
    public void setPayment (String payment) {
        this.payment =  payment;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-pickup@
    public Integer getPickup() {
        return pickup;
    }
	
    public void setPickup (Integer pickup) {
        this.pickup =  pickup;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-state@
    public Integer getState() {
        return state;
    }
	
    public void setState (Integer state) {
        this.state =  state;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-accept_user@
    public String getAcceptUser() {
        return acceptUser;
    }
	
    public void setAcceptUser (String acceptUser) {
        this.acceptUser =  acceptUser;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-imgs@
    public String getImgs() {
        return imgs;
    }
	
    public void setImgs (String imgs) {
        this.imgs =  imgs;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-remark@
    public String getRemark() {
        return remark;
    }
	
    public void setRemark (String remark) {
        this.remark =  remark;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_order@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (people==null) people=__DEFAULT_PEOPLE;
        if (money==null) money=__DEFAULT_MONEY;
        if (pickup==null) pickup=__DEFAULT_PICKUP;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_order@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (people==null) people=__DEFAULT_PEOPLE;
        if (money==null) money=__DEFAULT_MONEY;
        if (pickup==null) pickup=__DEFAULT_PICKUP;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
