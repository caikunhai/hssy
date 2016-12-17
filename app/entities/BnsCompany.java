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
	* - time      : 2016/12/17 ��Ԫ at 14:41:30 CST
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
 * <p>Title: BnsCompany</p>
 *
 * <p>Description: Domain Object describing a BnsCompany entity</p>
 *
 */
@Entity (name="BnsCompany")
@Table (name="bns_company")
@NamedQueries({
	 @NamedQuery(name="BnsCompany.findAll", query="SELECT bnscompany FROM BnsCompany bnscompany")
	,@NamedQuery(name="BnsCompany.findByCity", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.city = :city")
	,@NamedQuery(name="BnsCompany.findByCityContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.city like :city")

	,@NamedQuery(name="BnsCompany.findByName", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.name = :name")
	,@NamedQuery(name="BnsCompany.findByNameContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.name like :name")

	,@NamedQuery(name="BnsCompany.findByLogo", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.logo = :logo")
	,@NamedQuery(name="BnsCompany.findByLogoContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.logo like :logo")

	,@NamedQuery(name="BnsCompany.findByAddress", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.address = :address")
	,@NamedQuery(name="BnsCompany.findByAddressContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.address like :address")

	,@NamedQuery(name="BnsCompany.findByFrName", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.frName = :frName")
	,@NamedQuery(name="BnsCompany.findByFrNameContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.frName like :frName")

	,@NamedQuery(name="BnsCompany.findByFrMobile", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.frMobile = :frMobile")
	,@NamedQuery(name="BnsCompany.findByFrMobileContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.frMobile like :frMobile")

	,@NamedQuery(name="BnsCompany.findByLinkman", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.linkman = :linkman")
	,@NamedQuery(name="BnsCompany.findByLinkmanContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.linkman like :linkman")

	,@NamedQuery(name="BnsCompany.findByMobile", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.mobile = :mobile")
	,@NamedQuery(name="BnsCompany.findByMobileContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.mobile like :mobile")

	,@NamedQuery(name="BnsCompany.findByGos", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.gos = :gos")
	,@NamedQuery(name="BnsCompany.findByGosContaining", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.gos like :gos")

	,@NamedQuery(name="BnsCompany.findByHistory", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.history = :history")

	,@NamedQuery(name="BnsCompany.findByNum", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.num = :num")

	,@NamedQuery(name="BnsCompany.findByState", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.state = :state")

	,@NamedQuery(name="BnsCompany.findByRank", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.rank = :rank")

	,@NamedQuery(name="BnsCompany.findByCreatedTime", query="SELECT bnscompany FROM BnsCompany bnscompany WHERE bnscompany.createdTime = :createdTime")

})

public class BnsCompany implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_HISTORY = Integer.valueOf(0);
	public static final Integer __DEFAULT_NUM = Integer.valueOf(0);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);
	public static final Integer __DEFAULT_RANK = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsCompany.findAll";
    public static final String FIND_BY_CITY = "BnsCompany.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="BnsCompany.findByCityContaining";
    public static final String FIND_BY_NAME = "BnsCompany.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BnsCompany.findByNameContaining";
    public static final String FIND_BY_LOGO = "BnsCompany.findByLogo";
    public static final String FIND_BY_LOGO_CONTAINING ="BnsCompany.findByLogoContaining";
    public static final String FIND_BY_ADDRESS = "BnsCompany.findByAddress";
    public static final String FIND_BY_ADDRESS_CONTAINING ="BnsCompany.findByAddressContaining";
    public static final String FIND_BY_FRNAME = "BnsCompany.findByFrName";
    public static final String FIND_BY_FRNAME_CONTAINING ="BnsCompany.findByFrNameContaining";
    public static final String FIND_BY_FRMOBILE = "BnsCompany.findByFrMobile";
    public static final String FIND_BY_FRMOBILE_CONTAINING ="BnsCompany.findByFrMobileContaining";
    public static final String FIND_BY_LINKMAN = "BnsCompany.findByLinkman";
    public static final String FIND_BY_LINKMAN_CONTAINING ="BnsCompany.findByLinkmanContaining";
    public static final String FIND_BY_MOBILE = "BnsCompany.findByMobile";
    public static final String FIND_BY_MOBILE_CONTAINING ="BnsCompany.findByMobileContaining";
    public static final String FIND_BY_GOS = "BnsCompany.findByGos";
    public static final String FIND_BY_GOS_CONTAINING ="BnsCompany.findByGosContaining";
    public static final String FIND_BY_HISTORY = "BnsCompany.findByHistory";
    public static final String FIND_BY_NUM = "BnsCompany.findByNum";
    public static final String FIND_BY_STATE = "BnsCompany.findByState";
    public static final String FIND_BY_RANK = "BnsCompany.findByRank";
    public static final String FIND_BY_CREATEDTIME = "BnsCompany.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @city-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @city-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-city@
    @Column(name="city"  , length=64 , nullable=true , unique=false)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=60 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @logo-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @logo-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-logo@
    @Column(name="logo"  , length=100 , nullable=true , unique=false)
    private String logo; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @address-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @address-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-address@
    @Column(name="address"  , length=100 , nullable=true , unique=false)
    private String address; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @fr_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @fr_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-fr_name@
    @Column(name="fr_name"  , length=30 , nullable=true , unique=false)
    private String frName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @fr_mobile-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @fr_mobile-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-fr_mobile@
    @Column(name="fr_mobile"  , length=20 , nullable=true , unique=false)
    private String frMobile; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @linkman-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @linkman-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-linkman@
    @Column(name="linkman"  , length=30 , nullable=true , unique=false)
    private String linkman; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @mobile-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @mobile-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-mobile@
    @Column(name="mobile"  , length=20 , nullable=true , unique=false)
    private String mobile; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @gos-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @gos-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-gos@
    @Column(name="gos"  , length=255 , nullable=true , unique=false)
    private String gos; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @history-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @history-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-history@
    @Column(name="history"   , nullable=true , unique=false)
    private Integer history; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @num-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @num-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-num@
    @Column(name="num"   , nullable=true , unique=false)
    private Integer num; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @rank-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @rank-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-rank@
    @Column(name="rank"   , nullable=true , unique=false)
    private Integer rank; 
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
    public BnsCompany() {
    }

	/**
	* All field constructor 
	*/
    public BnsCompany(
       String id,
       String city,
       String name,
       String logo,
       String address,
       String frName,
       String frMobile,
       String linkman,
       String mobile,
       String gos,
       Integer history,
       Integer num,
       Integer state,
       Integer rank,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCity (city);
       setName (name);
       setLogo (logo);
       setAddress (address);
       setFrName (frName);
       setFrMobile (frMobile);
       setLinkman (linkman);
       setMobile (mobile);
       setGos (gos);
       setHistory (history);
       setNum (num);
       setState (state);
       setRank (rank);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsCompany flat() {
	   return new BnsCompany(
          getId(),
          getCity(),
          getName(),
          getLogo(),
          getAddress(),
          getFrName(),
          getFrMobile(),
          getLinkman(),
          getMobile(),
          getGos(),
          getHistory(),
          getNum(),
          getState(),
          getRank(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-city@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-logo@
    public String getLogo() {
        return logo;
    }
	
    public void setLogo (String logo) {
        this.logo =  logo;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-address@
    public String getAddress() {
        return address;
    }
	
    public void setAddress (String address) {
        this.address =  address;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-fr_name@
    public String getFrName() {
        return frName;
    }
	
    public void setFrName (String frName) {
        this.frName =  frName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-fr_mobile@
    public String getFrMobile() {
        return frMobile;
    }
	
    public void setFrMobile (String frMobile) {
        this.frMobile =  frMobile;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-linkman@
    public String getLinkman() {
        return linkman;
    }
	
    public void setLinkman (String linkman) {
        this.linkman =  linkman;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-gos@
    public String getGos() {
        return gos;
    }
	
    public void setGos (String gos) {
        this.gos =  gos;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-history@
    public Integer getHistory() {
        return history;
    }
	
    public void setHistory (Integer history) {
        this.history =  history;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-num@
    public Integer getNum() {
        return num;
    }
	
    public void setNum (Integer num) {
        this.num =  num;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-rank@
    public Integer getRank() {
        return rank;
    }
	
    public void setRank (Integer rank) {
        this.rank =  rank;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_company@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (history==null) history=__DEFAULT_HISTORY;
        if (num==null) num=__DEFAULT_NUM;
        if (state==null) state=__DEFAULT_STATE;
        if (rank==null) rank=__DEFAULT_RANK;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_company@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (history==null) history=__DEFAULT_HISTORY;
        if (num==null) num=__DEFAULT_NUM;
        if (state==null) state=__DEFAULT_STATE;
        if (rank==null) rank=__DEFAULT_RANK;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
