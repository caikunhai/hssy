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
	* - time      : 2016/12/20 ��Ԫ at 00:23:43 CST
*/
package entities;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsOrderChild</p>
 *
 * <p>Description: Domain Object describing a BnsOrderChild entity</p>
 *
 */
@Entity (name="BnsOrderChild")
@Table (name="bns_order_child")
@NamedQueries({
	 @NamedQuery(name="BnsOrderChild.findAll", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild")
	,@NamedQuery(name="BnsOrderChild.findByCustomer", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.customer = :customer")
	,@NamedQuery(name="BnsOrderChild.findByCustomerContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.customer like :customer")

	,@NamedQuery(name="BnsOrderChild.findByIdcard", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.idcard = :idcard")
	,@NamedQuery(name="BnsOrderChild.findByIdcardContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.idcard like :idcard")

	,@NamedQuery(name="BnsOrderChild.findByMobile", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.mobile = :mobile")
	,@NamedQuery(name="BnsOrderChild.findByMobileContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.mobile like :mobile")

	,@NamedQuery(name="BnsOrderChild.findByPeople", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.people = :people")

	,@NamedQuery(name="BnsOrderChild.findByCloth", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.cloth = :cloth")
	,@NamedQuery(name="BnsOrderChild.findByClothContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.cloth like :cloth")

	,@NamedQuery(name="BnsOrderChild.findBySite", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.site = :site")
	,@NamedQuery(name="BnsOrderChild.findBySiteContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.site like :site")

	,@NamedQuery(name="BnsOrderChild.findByHotel", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.hotel = :hotel")
	,@NamedQuery(name="BnsOrderChild.findByHotelContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.hotel like :hotel")

	,@NamedQuery(name="BnsOrderChild.findByPickup", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.pickup = :pickup")

	,@NamedQuery(name="BnsOrderChild.findByRemark", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.remark = :remark")
	,@NamedQuery(name="BnsOrderChild.findByRemarkContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.remark like :remark")

	,@NamedQuery(name="BnsOrderChild.findByImgs", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.imgs = :imgs")
	,@NamedQuery(name="BnsOrderChild.findByImgsContaining", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.imgs like :imgs")

	,@NamedQuery(name="BnsOrderChild.findByCreatedTime", query="SELECT bnsorderchild FROM BnsOrderChild bnsorderchild WHERE bnsorderchild.createdTime = :createdTime")

})

public class BnsOrderChild implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_PEOPLE = Integer.valueOf(0);
	public static final Integer __DEFAULT_PICKUP = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsOrderChild.findAll";
    public static final String FIND_BY_CUSTOMER = "BnsOrderChild.findByCustomer";
    public static final String FIND_BY_CUSTOMER_CONTAINING ="BnsOrderChild.findByCustomerContaining";
    public static final String FIND_BY_IDCARD = "BnsOrderChild.findByIdcard";
    public static final String FIND_BY_IDCARD_CONTAINING ="BnsOrderChild.findByIdcardContaining";
    public static final String FIND_BY_MOBILE = "BnsOrderChild.findByMobile";
    public static final String FIND_BY_MOBILE_CONTAINING ="BnsOrderChild.findByMobileContaining";
    public static final String FIND_BY_PEOPLE = "BnsOrderChild.findByPeople";
    public static final String FIND_BY_CLOTH = "BnsOrderChild.findByCloth";
    public static final String FIND_BY_CLOTH_CONTAINING ="BnsOrderChild.findByClothContaining";
    public static final String FIND_BY_SITE = "BnsOrderChild.findBySite";
    public static final String FIND_BY_SITE_CONTAINING ="BnsOrderChild.findBySiteContaining";
    public static final String FIND_BY_HOTEL = "BnsOrderChild.findByHotel";
    public static final String FIND_BY_HOTEL_CONTAINING ="BnsOrderChild.findByHotelContaining";
    public static final String FIND_BY_PICKUP = "BnsOrderChild.findByPickup";
    public static final String FIND_BY_REMARK = "BnsOrderChild.findByRemark";
    public static final String FIND_BY_REMARK_CONTAINING ="BnsOrderChild.findByRemarkContaining";
    public static final String FIND_BY_IMGS = "BnsOrderChild.findByImgs";
    public static final String FIND_BY_IMGS_CONTAINING ="BnsOrderChild.findByImgsContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsOrderChild.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

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
    @Column(name="cloth"  , length=255 , nullable=true , unique=false)
    private String cloth; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @site-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @site-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-site@
    @Column(name="site"  , length=255 , nullable=true , unique=false)
    private String site; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @hotel-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @hotel-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hotel@
    @Column(name="hotel"  , length=255 , nullable=true , unique=false)
    private String hotel; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @pickup-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @pickup-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-pickup@
    @Column(name="pickup"   , nullable=true , unique=false)
    private Integer pickup; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @remark-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @remark-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-remark@
    @Column(name="remark"  , length=100 , nullable=true , unique=false)
    private String remark; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @imgs-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @imgs-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-imgs@
    @Column(name="imgs"  , length=100 , nullable=true , unique=false)
    private String imgs; 
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
    public BnsOrderChild() {
    }

	/**
	* All field constructor 
	*/
    public BnsOrderChild(
       String id,
       String customer,
       String idcard,
       String mobile,
       Integer people,
       String cloth,
       String site,
       String hotel,
       Integer pickup,
       String remark,
       String imgs,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCustomer (customer);
       setIdcard (idcard);
       setMobile (mobile);
       setPeople (people);
       setCloth (cloth);
       setSite (site);
       setHotel (hotel);
       setPickup (pickup);
       setRemark (remark);
       setImgs (imgs);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsOrderChild flat() {
	   return new BnsOrderChild(
          getId(),
          getCustomer(),
          getIdcard(),
          getMobile(),
          getPeople(),
          getCloth(),
          getSite(),
          getHotel(),
          getPickup(),
          getRemark(),
          getImgs(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-pickup@
    public Integer getPickup() {
        return pickup;
    }
	
    public void setPickup (Integer pickup) {
        this.pickup =  pickup;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-imgs@
    public String getImgs() {
        return imgs;
    }
	
    public void setImgs (String imgs) {
        this.imgs =  imgs;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_order_child@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (people==null) people=__DEFAULT_PEOPLE;
        if (pickup==null) pickup=__DEFAULT_PICKUP;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_order_child@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (people==null) people=__DEFAULT_PEOPLE;
        if (pickup==null) pickup=__DEFAULT_PICKUP;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
