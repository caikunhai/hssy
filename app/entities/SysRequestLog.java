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
	* - time      : 2016/09/28 ��Ԫ at 17:50:23 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: SysRequestLog</p>
 *
 * <p>Description: Domain Object describing a SysRequestLog entity</p>
 *
 */
@Entity (name="SysRequestLog")
@Table (name="sys_request_log")
@NamedQueries({
	 @NamedQuery(name="SysRequestLog.findAll", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog")
	,@NamedQuery(name="SysRequestLog.findByPath", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.path = :path")
	,@NamedQuery(name="SysRequestLog.findByPathContaining", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.path like :path")

	,@NamedQuery(name="SysRequestLog.findByHeader", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.header = :header")
	,@NamedQuery(name="SysRequestLog.findByHeaderContaining", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.header like :header")

	,@NamedQuery(name="SysRequestLog.findByBody", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.body = :body")
	,@NamedQuery(name="SysRequestLog.findByBodyContaining", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.body like :body")

	,@NamedQuery(name="SysRequestLog.findByIp", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.ip = :ip")
	,@NamedQuery(name="SysRequestLog.findByIpContaining", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.ip like :ip")

	,@NamedQuery(name="SysRequestLog.findByQuery", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.query = :query")
	,@NamedQuery(name="SysRequestLog.findByQueryContaining", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.query like :query")

	,@NamedQuery(name="SysRequestLog.findByVer", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.ver = :ver")
	,@NamedQuery(name="SysRequestLog.findByVerContaining", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.ver like :ver")

	,@NamedQuery(name="SysRequestLog.findByCreatedTime", query="SELECT sysrequestlog FROM SysRequestLog sysrequestlog WHERE sysrequestlog.createdTime = :createdTime")

})

public class SysRequestLog implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "SysRequestLog.findAll";
    public static final String FIND_BY_PATH = "SysRequestLog.findByPath";
    public static final String FIND_BY_PATH_CONTAINING ="SysRequestLog.findByPathContaining";
    public static final String FIND_BY_HEADER = "SysRequestLog.findByHeader";
    public static final String FIND_BY_HEADER_CONTAINING ="SysRequestLog.findByHeaderContaining";
    public static final String FIND_BY_BODY = "SysRequestLog.findByBody";
    public static final String FIND_BY_BODY_CONTAINING ="SysRequestLog.findByBodyContaining";
    public static final String FIND_BY_IP = "SysRequestLog.findByIp";
    public static final String FIND_BY_IP_CONTAINING ="SysRequestLog.findByIpContaining";
    public static final String FIND_BY_QUERY = "SysRequestLog.findByQuery";
    public static final String FIND_BY_QUERY_CONTAINING ="SysRequestLog.findByQueryContaining";
    public static final String FIND_BY_VER = "SysRequestLog.findByVer";
    public static final String FIND_BY_VER_CONTAINING ="SysRequestLog.findByVerContaining";
    public static final String FIND_BY_CREATEDTIME = "SysRequestLog.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @path-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @path-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-path@
    @Column(name="path"  , length=255 , nullable=true , unique=false)
    private String path; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @header-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @header-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-header@
    @Column(name="header"   , nullable=true , unique=false)
    private String header; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @body-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @body-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-body@
    @Column(name="body"   , nullable=true , unique=false)
    private String body; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ip-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ip-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ip@
    @Column(name="ip"  , length=64 , nullable=true , unique=false)
    private String ip; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @query-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @query-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-query@
    @Column(name="query"   , nullable=true , unique=false)
    private String query; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ver-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ver-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ver@
    @Column(name="ver"  , length=32 , nullable=true , unique=false)
    private String ver; 
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
    public SysRequestLog() {
    }

	/**
	* All field constructor 
	*/
    public SysRequestLog(
       Long id,
       String path,
       String header,
       String body,
       String ip,
       String query,
       String ver,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setPath (path);
       setHeader (header);
       setBody (body);
       setIp (ip);
       setQuery (query);
       setVer (ver);
       setCreatedTime (createdTime);
       //parents
    }

	public SysRequestLog flat() {
	   return new SysRequestLog(
          getId(),
          getPath(),
          getHeader(),
          getBody(),
          getIp(),
          getQuery(),
          getVer(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-path@
    public String getPath() {
        return path;
    }
	
    public void setPath (String path) {
        this.path =  path;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-header@
    public String getHeader() {
        return header;
    }
	
    public void setHeader (String header) {
        this.header =  header;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-body@
    public String getBody() {
        return body;
    }
	
    public void setBody (String body) {
        this.body =  body;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ip@
    public String getIp() {
        return ip;
    }
	
    public void setIp (String ip) {
        this.ip =  ip;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-query@
    public String getQuery() {
        return query;
    }
	
    public void setQuery (String query) {
        this.query =  query;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ver@
    public String getVer() {
        return ver;
    }
	
    public void setVer (String ver) {
        this.ver =  ver;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-sys_request_log@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-sys_request_log@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
