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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2016/11/16 ��Ԫ at 10:46:26 CST
*/
package entities;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BnsCompany.class)
public class BnsCompany_ {

    public static volatile SingularAttribute<BnsCompany, String> id;

    public static volatile SingularAttribute<BnsCompany, String> city;
    public static volatile SingularAttribute<BnsCompany, String> company;
    public static volatile SingularAttribute<BnsCompany, String> logo;
    public static volatile SingularAttribute<BnsCompany, String> license;
    public static volatile SingularAttribute<BnsCompany, String> address;
    public static volatile SingularAttribute<BnsCompany, String> linkman;
    public static volatile SingularAttribute<BnsCompany, String> mobile;
    public static volatile SingularAttribute<BnsCompany, String> frName;
    public static volatile SingularAttribute<BnsCompany, String> frMobile;
    public static volatile SingularAttribute<BnsCompany, String> gos;
    public static volatile SingularAttribute<BnsCompany, Integer> history;
    public static volatile SingularAttribute<BnsCompany, Integer> num;
    public static volatile SingularAttribute<BnsCompany, Integer> state;
    public static volatile SingularAttribute<BnsCompany, Integer> rank;
    public static volatile SingularAttribute<BnsCompany, Timestamp> createdTime;




}
