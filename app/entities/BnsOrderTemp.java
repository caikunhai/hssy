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
	* - time      : 2017/01/14 ��Ԫ at 13:18:39 CST
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
 * <p>Title: BnsOrderTemp</p>
 *
 * <p>Description: Domain Object describing a BnsOrderTemp entity</p>
 *
 */
@Entity (name="BnsOrderTemp")
@Table (name="bns_order_temp")
@NamedQueries({
	 @NamedQuery(name="BnsOrderTemp.findAll", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp")
	,@NamedQuery(name="BnsOrderTemp.findByToken", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.token = :token")
	,@NamedQuery(name="BnsOrderTemp.findByTokenContaining", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.token like :token")

	,@NamedQuery(name="BnsOrderTemp.findByCompany", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.company = :company")
	,@NamedQuery(name="BnsOrderTemp.findByCompanyContaining", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.company like :company")

	,@NamedQuery(name="BnsOrderTemp.findByBusiness", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.business = :business")
	,@NamedQuery(name="BnsOrderTemp.findByBusinessContaining", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.business like :business")

	,@NamedQuery(name="BnsOrderTemp.findBySite", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.site = :site")
	,@NamedQuery(name="BnsOrderTemp.findBySiteContaining", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.site like :site")

	,@NamedQuery(name="BnsOrderTemp.findBySiteMoney", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.siteMoney = :siteMoney")

	,@NamedQuery(name="BnsOrderTemp.findByHotel", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.hotel = :hotel")
	,@NamedQuery(name="BnsOrderTemp.findByHotelContaining", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.hotel like :hotel")

	,@NamedQuery(name="BnsOrderTemp.findByHotelMoney", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.hotelMoney = :hotelMoney")

	,@NamedQuery(name="BnsOrderTemp.findByCreatedTime", query="SELECT bnsordertemp FROM BnsOrderTemp bnsordertemp WHERE bnsordertemp.createdTime = :createdTime")

})

public class BnsOrderTemp implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final java.math.BigDecimal __DEFAULT_SITE_MONEY = java.math.BigDecimal.valueOf(0.00);
	public static final java.math.BigDecimal __DEFAULT_HOTEL_MONEY = java.math.BigDecimal.valueOf(0.00);

    public static final String FIND_ALL = "BnsOrderTemp.findAll";
    public static final String FIND_BY_TOKEN = "BnsOrderTemp.findByToken";
    public static final String FIND_BY_TOKEN_CONTAINING ="BnsOrderTemp.findByTokenContaining";
    public static final String FIND_BY_COMPANY = "BnsOrderTemp.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsOrderTemp.findByCompanyContaining";
    public static final String FIND_BY_BUSINESS = "BnsOrderTemp.findByBusiness";
    public static final String FIND_BY_BUSINESS_CONTAINING ="BnsOrderTemp.findByBusinessContaining";
    public static final String FIND_BY_SITE = "BnsOrderTemp.findBySite";
    public static final String FIND_BY_SITE_CONTAINING ="BnsOrderTemp.findBySiteContaining";
    public static final String FIND_BY_SITEMONEY = "BnsOrderTemp.findBySiteMoney";
    public static final String FIND_BY_HOTEL = "BnsOrderTemp.findByHotel";
    public static final String FIND_BY_HOTEL_CONTAINING ="BnsOrderTemp.findByHotelContaining";
    public static final String FIND_BY_HOTELMONEY = "BnsOrderTemp.findByHotelMoney";
    public static final String FIND_BY_CREATEDTIME = "BnsOrderTemp.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @token-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @token-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-token@
    @Column(name="token"  , length=100 , nullable=true , unique=false)
    private String token; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @company-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @company-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-company@
    @Column(name="company"  , length=64 , nullable=true , unique=false)
    private String company; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @business-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @business-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-business@
    @Column(name="business"  , length=64 , nullable=true , unique=false)
    private String business; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @site-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @site-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-site@
    @Column(name="site"  , length=255 , nullable=true , unique=false)
    private String site; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @site_money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @site_money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-site_money@
    @Column(name="site_money"   , nullable=true , unique=false)
    private java.math.BigDecimal siteMoney; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @hotel-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @hotel-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hotel@
    @Column(name="hotel"  , length=255 , nullable=true , unique=false)
    private String hotel; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @hotel_money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @hotel_money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hotel_money@
    @Column(name="hotel_money"   , nullable=true , unique=false)
    private java.math.BigDecimal hotelMoney; 
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
    public BnsOrderTemp() {
    }

	/**
	* All field constructor 
	*/
    public BnsOrderTemp(
       String id,
       String token,
       String company,
       String business,
       String site,
       java.math.BigDecimal siteMoney,
       String hotel,
       java.math.BigDecimal hotelMoney,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setToken (token);
       setCompany (company);
       setBusiness (business);
       setSite (site);
       setSiteMoney (siteMoney);
       setHotel (hotel);
       setHotelMoney (hotelMoney);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsOrderTemp flat() {
	   return new BnsOrderTemp(
          getId(),
          getToken(),
          getCompany(),
          getBusiness(),
          getSite(),
          getSiteMoney(),
          getHotel(),
          getHotelMoney(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-token@
    public String getToken() {
        return token;
    }
	
    public void setToken (String token) {
        this.token =  token;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-company@
    public String getCompany() {
        return company;
    }
	
    public void setCompany (String company) {
        this.company =  company;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-business@
    public String getBusiness() {
        return business;
    }
	
    public void setBusiness (String business) {
        this.business =  business;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-site_money@
    public java.math.BigDecimal getSiteMoney() {
        return siteMoney;
    }
	
    public void setSiteMoney (java.math.BigDecimal siteMoney) {
        this.siteMoney =  siteMoney;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-hotel_money@
    public java.math.BigDecimal getHotelMoney() {
        return hotelMoney;
    }
	
    public void setHotelMoney (java.math.BigDecimal hotelMoney) {
        this.hotelMoney =  hotelMoney;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_order_temp@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (siteMoney==null) siteMoney=__DEFAULT_SITE_MONEY;
        if (hotelMoney==null) hotelMoney=__DEFAULT_HOTEL_MONEY;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_order_temp@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (siteMoney==null) siteMoney=__DEFAULT_SITE_MONEY;
        if (hotelMoney==null) hotelMoney=__DEFAULT_HOTEL_MONEY;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
