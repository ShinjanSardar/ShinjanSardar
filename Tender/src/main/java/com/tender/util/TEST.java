/*
 * //package com.kmc.portal.assessment.dao; // //import
 * com.kmc.mas.mtps.assessment.dto.KMCAssementAssessDtlDTO; //import
 * com.kmc.mas.mtps.util.UtilityForAll; //import
 * com.kmc.portal.application.constants.KMCAssessmentAddChangeConstants;
 * //import com.kmc.portal.application.constants.KMCAssessmentConstants;
 * //import com.kmc.portal.application.constants.KMCAssessmentLOIConstants;
 * //import com.kmc.portal.application.constants.KMCDocumentDownloadConstants;
 * //import com.kmc.portal.application.constants.KMCHearingConstants; //import
 * com.kmc.portal.assessment.utility.KMCAssessmentUtility; //import
 * com.kmc.portal.bo.print.departmental.ApplicationDescDetails; //import
 * com.kmc.portal.bo.print.departmental.AssesseeRoDto; //import
 * com.kmc.portal.bo.print.departmental.AssesseeWaiverDto; //import
 * com.kmc.portal.bo.print.departmental.AssessmentMultiple; //import
 * com.kmc.portal.bo.print.departmental.FSReceipt; //import
 * com.kmc.portal.bo.print.departmental.FSReceiptBillDetails; //import
 * com.kmc.portal.bo.print.departmental.LoiDemandDto; //import
 * com.kmc.portal.bo.print.departmental.LoiReceipt; //import
 * com.kmc.portal.bo.print.departmental.MUTACert; //import
 * com.kmc.portal.bo.print.departmental.MutDto; //import
 * com.kmc.portal.bo.print.departmental.MutaStatBarcodeDetails; //import
 * com.kmc.portal.bo.print.departmental.MutaStatDto; //import
 * com.kmc.portal.bo.print.departmental.MutationBarcodeDetails; //import
 * com.kmc.portal.bo.print.departmental.MutationPrint; //import
 * com.kmc.portal.bo.print.departmental.MutationReceipt; //import
 * com.kmc.portal.bo.print.departmental.MutationReceiptBarcodeDetails; //import
 * com.kmc.portal.bo.print.departmental.MutationReceiptBillDetails; //import
 * com.kmc.portal.bo.print.departmental.MutationReceipts; //import
 * com.kmc.portal.bo.print.departmental.PDBarcodeDetails; //import
 * com.kmc.portal.bo.print.departmental.PDDemand; //import
 * com.kmc.portal.bo.print.departmental.PDReceipt; //import
 * com.kmc.portal.bo.print.departmental.PDReceiptBarcodeDetails; //import
 * com.kmc.portal.bo.print.departmental.PDReceiptBillDetails; //import
 * com.kmc.portal.bo.print.departmental.RevenuePrintObject; //import
 * com.kmc.portal.bo.print.departmental.SurchargeDetails; //import
 * com.kmc.portal.bo.print.departmental.TenantDetails; //import
 * com.kmc.portal.dto.business.AddChangeDto; //import
 * com.kmc.portal.dto.business.AddressAssesseeSearchDTO; //import
 * com.kmc.portal.dto.business.AddressChangeStatusDTO; //import
 * com.kmc.portal.dto.business.KMCPersonDTO; //import
 * com.kmc.portal.dto.business.KMCPortalCEDTO; //import
 * com.kmc.portal.dto.business.SuspenseDemandDTO; //import
 * com.kmc.portal.dto.business.ApplicationPurposeDTO; //import
 * com.kmc.portal.dto.business.AsmtPDReceiptDTO; //import
 * com.kmc.portal.dto.business.AssesseeHistoryDTO; //import
 * com.kmc.portal.dto.business.AssessmentPDBarcodeDTO; //import
 * com.kmc.portal.dto.business.DemandCollectionDTO; //import
 * com.kmc.portal.dto.business.DocDetailDTO; //import
 * com.kmc.portal.dto.business.KMCPortalAssessmentDTO; //import
 * com.kmc.portal.dto.business.KMCPortalHearingDTO; //import
 * com.kmc.portal.dto.business.MutaStatusDTO; //import
 * com.kmc.portal.dto.business.MutationDocDTO; //import
 * com.kmc.portal.dto.business.MutationPrintDTO; //import
 * com.kmc.portal.dto.business.MutationReceiptDTO; //import
 * com.kmc.portal.dto.business.MutationStatusDTO; //import
 * com.kmc.portal.dto.business.NOCStatusDTO; //import
 * com.kmc.portal.dto.business.MUTACertDTO; // somenath //import
 * com.kmc.portal.dto.business.PlanProposalDTO; //import
 * com.kmc.portal.dto.business.PremisesListDTO; //import
 * com.kmc.portal.dto.business.ReceiptDTO; //import
 * com.kmc.portal.dto.factory.DTOFactory; //import
 * com.kmc.portal.exception.KMCPortalBusinessException; //import
 * com.kmc.portal.payment.constants.KMCAssessmentPaymentConstants; //import
 * com.kmc.portal.payment.constants.KMCPortalPaymentConstants; //import
 * com.kmc.portal.returnObject.KMCPortalServiceReturnObject; //import
 * com.kmc.portal.revenue.dao.KMCPortalRevenueDAOIntf; //import
 * com.kmc.portalutil.KMCPortalPGConnectionManager; // //import
 * java.math.BigDecimal; // //import java.sql.CallableStatement; //import
 * java.sql.Connection; //import java.sql.Date; //import
 * java.sql.PreparedStatement; //import java.sql.ResultSet; //import
 * java.sql.SQLException; //import java.sql.Types; // //import
 * java.util.ArrayList; //import java.util.HashMap; //import java.util.Iterator;
 * //import java.util.List; //import java.util.Map; // //import
 * javax.sql.DataSource; // //import org.apache.log4j.Logger; // //import
 * org.springframework.dao.DataAccessException; //import
 * org.springframework.jdbc.InvalidResultSetAccessException; //import
 * org.springframework.jdbc.core.JdbcTemplate; //import
 * org.springframework.jdbc.core.RowMapper; //import
 * org.springframework.jdbc.core.SqlOutParameter; //import
 * org.springframework.jdbc.core.SqlParameter; //import
 * org.springframework.jdbc.object.SqlFunction; //import
 * org.springframework.jdbc.object.StoredProcedure; // //public class
 * KMCPortalAssessmentDAO implements KMCPortalAssessmentDAOIntf { // private
 * Logger log = Logger.getRootLogger(); // DataSource dataSourceAssessment; //
 * DataSource dataSourcePay; // DataSource dataSourceRevenue; // // private
 * JdbcTemplate jdbcTemplate; // private JdbcTemplate jdbcTemplatePay; //
 * private JdbcTemplate jdbcTemplateRevenue; // // public
 * KMCPortalServiceReturnObject getMUTACertDTO(HashMap infoMap) throws
 * KMCPortalBusinessException { // KMCPortalServiceReturnObject
 * _portalServiceReturnObject = new KMCPortalServiceReturnObject(); // // /////
 * Method requse of Query Services /////////////// // //
 * _portalServiceReturnObject =assessmentQueryDAO.getMUTADetails(infoMap); // //
 * return _portalServiceReturnObject; // } // // public
 * KMCPortalServiceReturnObject getHearingDateDetls(HashMap infoMap) throws
 * KMCPortalBusinessException { // // KMCPortalServiceReturnObject
 * _portalServiceReturnObject = new KMCPortalServiceReturnObject(); // String
 * _assesseeNo = (String) infoMap.get("ASSESSENO"); // String sqlQuery =
 * "SELECT t.asmt_assno ASS_NO,TO_Char(t.asmt_hear_date, 'dd/mm/yyyy') Hearing_Date,substr(t.asmt_proposed_qtr,5,1)||'/'||substr(t.asmt_proposed_qtr,1,4) Quarter,t.asmt_hear_off Hearing_Officer, t.asmt_hear_time Hearing_Time,decode(t.asmt_hear_status,'X','Complete','D','Complete','Pending') Status from asmt_hearing t where t.asmt_assno  = ? and t.asmt_hear_status <> 'C' order by t.asmt_hear_date"
 * ; // RowMapper rowMapper = new RowMapper() { // public Object
 * mapRow(ResultSet rs, int rowNum) throws SQLException { //
 * KMCPortalAssessmentDTO _asmtDTO = (KMCPortalAssessmentDTO) DTOFactory //
 * .createDTO("com.kmc.portal.dto.business.KMCPortalAssessmentDTO"); //
 * _asmtDTO.setHearingDate(rs.getString("Hearing_Date")); //
 * _asmtDTO.setHearingOfficer(rs.getString("Hearing_Officer")); //
 * _asmtDTO.setHearingTime(rs.getString("Hearing_Time")); //
 * _asmtDTO.setStatus(rs.getString("Status")); //
 * _asmtDTO.setQuarter(rs.getString("Quarter")); //
 * _asmtDTO.setAssesseNo(rs.getString("ASS_NO")); // return _asmtDTO; // // } //
 * }; // List retList = new ArrayList(); // retList =
 * jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, rowMapper); // if
 * (retList == null || retList.size() == 0) { // KMCPortalBusinessException
 * _portException = new KMCPortalBusinessException(); // _portException.
 * setErrMesg("Hearing records do not exist for the given Assessee Number "); //
 * throw _portException; // // } // HashMap returnMap = new HashMap(); //
 * returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.HEARINGLIST,
 * retList); // _portalServiceReturnObject.setReturnMap(returnMap); // return
 * _portalServiceReturnObject; // // } // // public KMCPortalServiceReturnObject
 * getAssesseeDtls(HashMap infoMap) throws KMCPortalBusinessException { // //
 * KMCPortalServiceReturnObject _portalServiceReturnObject = new
 * KMCPortalServiceReturnObject(); // String _assesseeNo = (String)
 * infoMap.get("ASSESSENO"); // System.out.println("assesseeNo:in ::::::DAO=" +
 * _assesseeNo); // // String ownerName = (String)infoMap.get("OWNERNMAE"); //
 * String wardNo = (String) infoMap.get("WARDNO"); // String streetCode =
 * (String) infoMap.get("STREETCODE"); // // String premiseType =
 * (String)infoMap.get("PREMTYPE"); // String premiseNo = (String)
 * infoMap.get("PREMNO"); // String sqlQuery = ""; // List retList = new
 * ArrayList(); // // RowMapper rowMapper = new RowMapper() { // public Object
 * mapRow(ResultSet rs, int rowNum) throws SQLException { // //
 * KMCPortalAssessmentDTO _asmtDTO = (KMCPortalAssessmentDTO) // //
 * DTOFactory.createDTO("com.kmc.portal.dto.business.KMCPortalAssessmentDTO");
 * // KMCPortalAssessmentDTO _asmtDTO = new KMCPortalAssessmentDTO(); //
 * _asmtDTO.setOwner(rs.getString("ASMT_OWN_1")); //
 * _asmtDTO.setAssesseNo(rs.getString("ASMT_ASSNO")); //
 * _asmtDTO.setAddress(rs.getString("ASMT_ADRS_1")); //
 * _asmtDTO.setPremiseNo(rs.getString("ASMT_PREM_NO")); //
 * _asmtDTO.setStatus(rs.getString("ASMT_STATUS")); //
 * _asmtDTO.setPinCode(rs.getString("ASMT_STREET_CODE")); //
 * _asmtDTO.setPersonLiable(rs.getString("asmt_person_liable")); // return
 * _asmtDTO; // // } // }; // // // String sqlQuery = "SELECT t.asmt_assno
 * ASS_NO,TO_Char(t.asmt_hear_date, // // 'dd/mm/yyyy') // //
 * Hearing_Date,substr(t.asmt_proposed_qtr,5,1)||'/'||substr(t.asmt_proposed_qtr
 * ,1,4) // // Quarter,t.asmt_hear_off Hearing_Officer, t.asmt_hear_time // //
 * Hearing_Time,decode(t.asmt_hear_status,'X','Complete','D','Complete','Pending
 * ') // // Status from asmt_hearing t where t.asmt_assno = ? and
 * t.asmt_hear_status <> // // 'C' order by t.asmt_hear_date"; // // if
 * ((_assesseeNo == null || _assesseeNo.equals(""))) { // sqlQuery =
 * KMCAssessmentConstants.getAssesseeDtlsQuery(); // // if (premiseNo == null ||
 * premiseNo.equals("")) { // retList = jdbcTemplate.query(sqlQuery, new
 * Object[] { wardNo, streetCode }, rowMapper); // } else if (premiseNo != null
 * && !premiseNo.equals("")) { // sqlQuery = sqlQuery +
 * " AND ASMT_PREM_NO = ? "; // // retList = jdbcTemplate.query(sqlQuery, new
 * Object[] { wardNo, streetCode, premiseNo }, rowMapper); // } // } else { //
 * sqlQuery = KMCAssessmentConstants.getAssesseeDtlsQueryByAssNo(); // retList =
 * jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, rowMapper); // }
 * // // System.out.println("sqlQuery:in ::::::DAO=" + sqlQuery); // // /* // *
 * if((_assesseeNo == null || _assesseeNo.equals("")) && (premiseNo == null ||
 * // * premiseNo.equals(""))) { retList = jdbcTemplate.query(sqlQuery,new // *
 * Object[]{wardNo,streetCode},rowMapper); } else if((_assesseeNo != null && //
 * * !_assesseeNo.equals("")) && (premiseNo != null && !premiseNo.equals(""))) {
 * // * sqlQuery = sqlQuery + " AND ASMT_ASSNO = ? AND ASMT_PREM_NO = ? "; // *
 * System.out.println("sqlQuery:in ::::::DAO="+sqlQuery); retList = // *
 * jdbcTemplate.query(sqlQuery,new // *
 * Object[]{wardNo,streetCode,_assesseeNo,premiseNo},rowMapper); } else // *
 * if(_assesseeNo != null && !_assesseeNo.equals("")) { sqlQuery = sqlQuery + //
 * * " AND ASMT_ASSNO = ? "; // *
 * System.out.println("sqlQuery:in ::::::DAO="+sqlQuery); // * // * retList =
 * jdbcTemplate.query(sqlQuery,new // *
 * Object[]{wardNo,streetCode,_assesseeNo},rowMapper); } else if(premiseNo != //
 * * null && !premiseNo.equals("")) { sqlQuery = sqlQuery + // *
 * " AND ASMT_PREM_NO = ? "; // *
 * System.out.println("sqlQuery:in ::::::DAO="+sqlQuery); // * // * retList =
 * jdbcTemplate.query(sqlQuery,new // *
 * Object[]{wardNo,streetCode,premiseNo},rowMapper); } //
 */
//
//		// System.out.println("retList :in ::::::DAO="+retList.size());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("No records Found for the given search.");
//			throw _portException;
//
//		}
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.HEARINGLIST, retList);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//		return _portalServiceReturnObject;
//
//	}
//
//	// shinjan
//	public KMCPortalServiceReturnObject auth(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("called auth method");
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//
//		try {
//			// System.out.println("userName by shinjan auth method in
//			// KMCPORtalAssesmentDao:::::"+infoMap.get("username"));
//			// String userName="ujjwal009";
//			String userName = (String) infoMap.get("username");
//			System.out.println("userName by shinjan auth method in KMCPORtalAssesmentDao try block:::::" + userName);
//			List session_list = new ArrayList();
//
//			RowMapper rowMapper_session = new RowMapper() {
//				public Object mapRow(ResultSet rs, int rowNum)
//
//				{
//					KMCPersonDTO _pDTO = new KMCPersonDTO();
//					try {
//
//						_pDTO.setLoginId(rs.getString("user_loginid"));
//						_pDTO.setAuth_status(rs.getString("auth_status"));
//
//						System.out.println("auth_status by shinjan in rowmapper:::::" + rs.getString("user_loginid"));
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					return _pDTO;
//				}
//
//			};
//			String sqlQueryses = KMCAssessmentConstants.checkAuthority();
//			System.out.println("session query:in ::::::DAO=" + sqlQueryses);
//
//			session_list = jdbcTemplate.query(sqlQueryses, new Object[] { userName }, rowMapper_session);
//			// session_list.add("ujjwal009");
//			System.out.println("session_list.size() by shinjan:::" + session_list.size());
////                      if(session_list==null || session_list.size()==0)
////                 {
////                
////                      _portException.setErrMesg("No records Found for the given search.");
////                      throw _portException;
////                      
////                 }
//			HashMap returnMap = new HashMap();
//			returnMap.put("session", session_list);
//			_portalServiceReturnObject.setReturnMap(returnMap);
////                      if(session_list.size()!=0){
////                      
////                        return "authenticated";
////                      }
////                      else{
////                        return "not-authenticated";
////                      }
//		} catch (InvalidResultSetAccessException eex) {
//			System.out.println("auth exception by shinjan:::");
//
//			eex.printStackTrace();
//		} catch (DataAccessException eeex) {
//			System.out.println("auth exception by shinjan:::");
//
//			eeex.printStackTrace();
//		} catch (Exception ex) {
//			System.out.println("auth exception by shinjan:::");
//
//			ex.printStackTrace();
//		}
//		return _portalServiceReturnObject;
//	}
//
//	// added angira///
//	public KMCPortalServiceReturnObject getCEDtls(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		System.out.println("assesseeNo:in ::::::DAO=" + _assesseeNo);
//
//		String wardNo = (String) infoMap.get("WARDNO");
//		System.out.println("wardNo:in CEDtls ::::::DAO=" + wardNo);
//
//		String ceNo = (String) infoMap.get("CENO");
//		System.out.println("ceNo:in CEDtls ::::::DAO=" + ceNo);
//
//		String streetCode = (String) infoMap.get("STREETCODE");
//		System.out.println("streetCode:in CEDtls ::::::DAO=" + streetCode);
//
//		String premiseNo = (String) infoMap.get("PREMNO");
//		System.out.println("premiseNo:in CEDtls ::::::DAO=" + premiseNo);
//
//		String tradeName = (String) infoMap.get("TRADENAME");
//		System.out.println("tradeName:in CEDtls ::::::DAO=" + tradeName);
//
//		String sqlQueryCe = "";
//		List retList = new ArrayList();
//		System.out.println("PRINT QUERY FOR CE1=" + sqlQueryCe);
//		RowMapper rowMapper = new RowMapper() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				// KMCPortalAssessmentDTO _asmtDTO = (KMCPortalAssessmentDTO)
//				// DTOFactory.createDTO("com.kmc.portal.dto.business.KMCPortalAssessmentDTO");
//				KMCPortalCEDTO _ceDTO = new KMCPortalCEDTO();
//				_ceDTO.setTradeName(rs.getString("LIC_TRADE_NAME"));
//				_ceDTO.setAssesseNo(rs.getString("LIC_ASSESSEE_NO"));
//				_ceDTO.setCENo(rs.getString("LIC_REGN_NO"));
//
//				_ceDTO.setOwnerName(rs.getString("LIC_OWNER_NAME"));
//
//				_ceDTO.setAddress(rs.getString("ADDRESS"));
//
//				_ceDTO.setTradeNature(rs.getString("TRADE_NATURE"));
//				_ceDTO.setStatus(rs.getString("LIC_STATUS"));
//				_ceDTO.setArea(rs.getString("LIC_AREA"));
//				_ceDTO.setWardNo(rs.getString("LIC_WARD_NO"));
//				_ceDTO.setStreetCode(rs.getString("LIC_STREET_CODE"));
//
//				return _ceDTO;
//			}
//		};
//		System.out.println("PRINT QUERY FOR CE2=" + _assesseeNo);
//
//		// angira//
//
//		if ((_assesseeNo == null || _assesseeNo.equals(""))) {
//
//			/// shinjan trade name check 07/08/2021
//			if (tradeName == null || tradeName.equals("")) {
//				sqlQueryCe = KMCAssessmentConstants.getCEDtlsQuery();
//				System.out.println("PRINT QUERY FOR CE3=" + sqlQueryCe);
//				if (premiseNo == null || premiseNo.equals(""))
//
//				{
//					System.out.println("PRINT QUERY FOR CE4  without trade name=" + sqlQueryCe);
//					retList = jdbcTemplate.query(sqlQueryCe, new Object[] { wardNo, streetCode }, rowMapper);
//				} else if (premiseNo != null && !premiseNo.equals("")) {
//					sqlQueryCe = sqlQueryCe + " AND t.lic_premises_no = ? ";
//					System.out.println("PRINT QUERY FOR CE5  without trade name=" + sqlQueryCe);
//					retList = jdbcTemplate.query(sqlQueryCe, new Object[] { wardNo, streetCode, premiseNo }, rowMapper);
//				}
//
//			} else if (tradeName != null || !tradeName.equals("")) {
//				sqlQueryCe = sqlQueryCe + " AND t.lic_premises_no = ? AND t.lic_trade_name=?";
//				System.out.println(" shinjan::::PRINT QUERY FOR CE6  with tared name and premise no=" + sqlQueryCe);
//				retList = jdbcTemplate.query(sqlQueryCe, new Object[] { wardNo, streetCode, premiseNo, tradeName },
//						rowMapper);
//			}
//
//		} else {
//			/// shinjan trade name check 07/08/2021
//			if (tradeName == null || tradeName.equals("")) {
//
//				sqlQueryCe = KMCAssessmentConstants.getCEDtlsQueryByAssNo();
//				retList = jdbcTemplate.query(sqlQueryCe, new Object[] { _assesseeNo }, rowMapper);
//				System.out.println("shinjan::::PRINT QUERY FOR CE7 without trade name =" + sqlQueryCe);
//			} else if (tradeName != null || !tradeName.equals("")) {
//				sqlQueryCe = KMCAssessmentConstants.getCEDtlsQueryByAssNo();
//				sqlQueryCe = sqlQueryCe + "  AND t.lic_trade_name=?";
//				retList = jdbcTemplate.query(sqlQueryCe, new Object[] { _assesseeNo, tradeName }, rowMapper);
//				System.out.println("PRINT QUERY FOR CE8 with tared name with _assesseeNo=" + sqlQueryCe);
//			}
//		}
//
//		System.out.println("sqlQuery:in CEDtls7 ::::::DAO=" + sqlQueryCe);
//		System.out.println("sqlQuery:in size 8::::::DAO=" + retList.size());
//
//		/*
//		 * if((_assesseeNo == null || _assesseeNo.equals("")) && (premiseNo == null ||
//		 * premiseNo.equals(""))) { retList = jdbcTemplate.query(sqlQuery,new
//		 * Object[]{wardNo,streetCode},rowMapper); } else if((_assesseeNo != null &&
//		 * !_assesseeNo.equals("")) && (premiseNo != null && !premiseNo.equals(""))) {
//		 * sqlQuery = sqlQuery + " AND ASMT_ASSNO = ? AND ASMT_PREM_NO = ? ";
//		 * System.out.println("sqlQuery:in ::::::DAO="+sqlQuery); retList =
//		 * jdbcTemplate.query(sqlQuery,new
//		 * Object[]{wardNo,streetCode,_assesseeNo,premiseNo},rowMapper); } else
//		 * if(_assesseeNo != null && !_assesseeNo.equals("")) { sqlQuery = sqlQuery +
//		 * " AND ASMT_ASSNO = ? ";
//		 * System.out.println("sqlQuery:in ::::::DAO="+sqlQuery);
//		 * 
//		 * retList = jdbcTemplate.query(sqlQuery,new
//		 * Object[]{wardNo,streetCode,_assesseeNo},rowMapper); } else if(premiseNo !=
//		 * null && !premiseNo.equals("")) { sqlQuery = sqlQuery +
//		 * " AND ASMT_PREM_NO = ? ";
//		 * System.out.println("sqlQuery:in ::::::DAO="+sqlQuery);
//		 * 
//		 * retList = jdbcTemplate.query(sqlQuery,new
//		 * Object[]{wardNo,streetCode,premiseNo},rowMapper); }
//		 */
//
//		// System.out.println("retList :in ::::::DAO="+retList.size());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("No records Found for the given search.");
//			throw _portException;
//
//		}
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.HEARINGLIST, retList);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//		return _portalServiceReturnObject;
//
//	}
//
//	private static final class PaymentStatusMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			KMCPortalAssessmentDTO asmtDTO = (KMCPortalAssessmentDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.KMCPortalAssessmentDTO");
//
//			asmtDTO.setQuarter(rs.getString("QUARTER"));
//			asmtDTO.setBillType(rs.getString("BILL_TYPE"));
//			asmtDTO.setShareType(rs.getString("SHARE_TYPE"));
//			asmtDTO.setAnnualval(rs.getString("ANNUAL_VALUATION"));
//			asmtDTO.setAmtPayable(rs.getString("AMOUNT_PAYABLE"));
//			asmtDTO.setRebateAllowed(rs.getString("REBATE_ALLOWED_UPTO"));
//			asmtDTO.setPenaltyImposed(rs.getString("PENALTY_TO_BE_IMPOSED_AFTER"));
//			asmtDTO.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
//
//			return asmtDTO;
//
//		}
//
//	}
//
//	private static final class RevReceiptDetRowMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			RevenuePrintObject _revPrintObj = new RevenuePrintObject();
//
//			_revPrintObj.setAssesseeNo(rs.getString("REV_ASSESSEE_NO"));
//			_revPrintObj.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			_revPrintObj.setTotalAmount(rs.getString("TXN_AMOUNT"));
//			_revPrintObj.setTotalAmountInWords(rs.getString("AMT_IN_WORDS"));
//			_revPrintObj.setReceiptDate(rs.getString("RECEIPT_DATE"));
//
//			return _revPrintObj;
//
//		}
//
//	}
//
//	private static final class RevASMTReceiptDetRowMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			RevenuePrintObject _revPrintObj = new RevenuePrintObject();
//
//			_revPrintObj.setPremisesNo(rs.getString("PREMISES_NO"));
//			_revPrintObj.setStreetName(rs.getString("STREET_NAME"));
//			_revPrintObj.setOwner(rs.getString("OWNER"));
//			_revPrintObj.setAddress(rs.getString("ADDRESS"));
//			_revPrintObj.setPinCode(rs.getString("PIN_CODE"));
//			_revPrintObj.setPrintedOn(UtilityForAll.getTodaysDate());
//
//			return _revPrintObj;
//
//		}
//
//	}
//
//	private static final class AssesseeValidMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			NOCStatusDTO nocDTO = (NOCStatusDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.NOCStatusDTO");
//
//			nocDTO.setCount(rs.getString("COUNT_MAC"));
//
//			return nocDTO;
//
//		}
//
//	}
//
//	private static final class ApplicationPurposeListMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			ApplicationPurposeDTO _applicationPurposeDTO = new ApplicationPurposeDTO();
//
//			_applicationPurposeDTO.setAppSlNo(rs.getString("APP_SL_NO"));
//			_applicationPurposeDTO.setAppSlNo1(rs.getString("APP_SL_NO"));
//			_applicationPurposeDTO.setAppDesc(rs.getString("APP_DESC"));
//			_applicationPurposeDTO.setAppShortDesc(rs.getString("APP_SHORT_DESC"));
//			_applicationPurposeDTO.setAppActiveDeactive(rs.getString("ACT_DEACT"));
//
//			return _applicationPurposeDTO;
//		}
//	}
//
//	// Added by Soumita
//	private static final class PremisesListMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			PremisesListDTO _premisesListDTO = new PremisesListDTO();
//
//			_premisesListDTO.setSurcrgUsgId(rs.getString("SURCRG_USG_ID"));
//			_premisesListDTO.setDetailsOfPremises(rs.getString("DETAILS_OF_PREMISES"));
//			_premisesListDTO.setActDeactFlag(rs.getString("ACT_DEACT_FLAG"));
//
//			return _premisesListDTO;
//		}
//	}
//
//	// Added by Soumita
//	private static final class DocDetailMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			DocDetailDTO _docDetailDTO = new DocDetailDTO();
//
//			_docDetailDTO.setAppSlNo(rs.getString("APP_SL_NO"));
//			_docDetailDTO.setDocName(rs.getString("DOC_NAME"));
//			_docDetailDTO.setDocType(rs.getString("DOC_TYPE"));
//			_docDetailDTO.setActDeact(rs.getString("ACT_DEACT"));
//
//			return _docDetailDTO;
//		}
//	}
//
//	// Added by Soumita
//	private static final class MutationStatusMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			MutationStatusDTO _mutationStatusDTO = new MutationStatusDTO();
//
//			_mutationStatusDTO.setCaseNo(rs.getString("ASMT_CASE_NUMBER"));
//			_mutationStatusDTO.setAsmtAssno(rs.getString("ASMT_ASSNO"));
//			_mutationStatusDTO.setOldOwner(rs.getString("OLD_OWNER"));
//			_mutationStatusDTO.setNewOwner(rs.getString("NEW_OWNER"));
//			_mutationStatusDTO.setNewAddress(rs.getString("NEW_ADDRESS"));
//			_mutationStatusDTO.setOldAddress(rs.getString("OLD_ADDRESS"));
//			_mutationStatusDTO.setStatus(rs.getString("DMD_STATUS"));
//			_mutationStatusDTO.setReceiptDate(rs.getString("ASMT_RCPT_DATE"));
//
//			return _mutationStatusDTO;
//		}
//
//	}
//
////  private static final class AssesseeDemandMapper implements RowMapper 
////      {
////          
////   //       List arraList = new ArrayList();
////            public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
////            {
////                   
////                         
////                         NOCStatusDTO nocDTO 
////                                    = (NOCStatusDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.NOCStatusDTO");  
////                         
////                         nocDTO.setCount("");
////                         nocDTO.setCount(rs.getString("COUNT_MAC"));
////                       
////                        return nocDTO;
////               
////            }
////      
////      }  
////    
//
////  private static final class OfficeCodeMapper implements RowMapper 
////      {
////          
////   //       List arraList = new ArrayList();
////            public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
////            {
////                   
////                         
////                         NOCStatusDTO nocDTO 
////                                    = (NOCStatusDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.NOCStatusDTO");  
////                         
////                       
////                         nocDTO.setOfficeCode(rs.getString("OFFICE_CODE"));
////                       
////                        return nocDTO;
////               
////            }
////      
////      }   
////    
//
//	private static final class CheckInstanceMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			NOCStatusDTO nocDTO = (NOCStatusDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.NOCStatusDTO");
//
//			nocDTO.setAssesseeNo(rs.getString("ASSESSEE_NO"));
//			return nocDTO;
//
//		}
//
//	}
//
//	private static final class FindSeqMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			NOCStatusDTO nocDTO = (NOCStatusDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.NOCStatusDTO");
//
//			nocDTO.setTempVar(rs.getString("SEQ"));
//
//			return nocDTO;
//
//		}
//
//	}
//
//	private static final class PayeeDetailsMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			KMCPortalAssessmentDTO asmtDTO = (KMCPortalAssessmentDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.KMCPortalAssessmentDTO");
//
//			asmtDTO.setPremiseNo(rs.getString("PREMISE_NO"));
//			asmtDTO.setPersonLiable(rs.getString("PERSON_LIABLE"));
//			asmtDTO.setOwner(rs.getString("OWNER"));
//			asmtDTO.setPinCode(rs.getString("PINCODE"));
//			asmtDTO.setMailingAddress(rs.getString("MAILING_ADDRESS") + " " + asmtDTO.getPinCode());
//
//			return asmtDTO;
//
//		}
//
//	}
//
//	private static final class SuspenseBalanceMapper implements RowMapper {
//
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			KMCPortalAssessmentDTO asmtDTO = (KMCPortalAssessmentDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.KMCPortalAssessmentDTO");
//
//			asmtDTO.setSuspBalance(rs.getString("UNADJUSTED_SUSP_BALANCE"));
//
//			return asmtDTO;
//
//		}
//
//	}
//
//	private static final class AssessmentCurrentRowMapper implements RowMapper {
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			String todaysDate = UtilityForAll.getTodaysDate();
//			DemandCollectionDTO demandCollectionDTO = (DemandCollectionDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.DemandCollectionDTO");
//			demandCollectionDTO.setBillNo(rs.getString("asmt_bill_no"));
//			demandCollectionDTO.setPhysicalBillNo(rs.getString("asmt_physical_bill_no"));
//			demandCollectionDTO.setPresentationDate(rs.getString("asmt_presentation_date"));
//			demandCollectionDTO.setBillType(rs.getString("asmt_bill_type"));
//			demandCollectionDTO
//					.setFromQtr(KMCAssessmentUtility.convertEffQuarterFromStorageToView(rs.getString("from_qtr")));
//			demandCollectionDTO
//					.setToQtr(KMCAssessmentUtility.convertEffQuarterFromStorageToView(rs.getString("to_qtr")));
//			String grossAmt = rs.getString("ASMT_PAYABLE_AMT");
//			grossAmt = String.valueOf(Math.round(new Double(grossAmt).doubleValue()));
//			demandCollectionDTO.setGrossAmount(grossAmt);
//			demandCollectionDTO.setShareType(rs.getString("asmt_share_type"));
//			demandCollectionDTO.setSelectAll("");
//			demandCollectionDTO.setSelectFlag("");
//			demandCollectionDTO.setClubbedBill("NO");
//			demandCollectionDTO.setAV(rs.getString("ASMT_AV"));
//			demandCollectionDTO.setFreshBillNo(rs.getString("ASMT_FS_BILL_NO"));
//			String rebateDate = rs.getString("asmt_rebate_date");
//			if (grossAmt == null || grossAmt == "")
//				grossAmt = new Double(0).toString();
//			demandCollectionDTO.setRebateDate(rebateDate);
//			return demandCollectionDTO;
//
//		}// end of method
//
//	}
//
//	private static final class SuspensePaymentRowMapper implements RowMapper {
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			SuspenseDemandDTO suspenseDemandDTO = new SuspenseDemandDTO();
//			suspenseDemandDTO.setDemandNo(rs.getString("DEMAND_NO"));
//			suspenseDemandDTO.setAssesseeNo(rs.getString("ASSNO"));
//			suspenseDemandDTO.setApplicantName(rs.getString("APPLICANT_NAME"));
//			suspenseDemandDTO.setAddress(rs.getString("ADDRESS"));
//			suspenseDemandDTO.setEmail("EMAIL");
//			suspenseDemandDTO.setPaymentType(rs.getString("PAYMET_TYPE"));
//			suspenseDemandDTO.setAmount(rs.getString("AMOUNT"));
//			suspenseDemandDTO.setPaymentFlag(rs.getString("PAYMENT_FLAG"));
//
//			suspenseDemandDTO.setMobileNo(rs.getString("MOBILE_NO"));
//			suspenseDemandDTO.setPaymentDesc(rs.getString("PAYMENT_DESC"));
//			suspenseDemandDTO.setBiCode(rs.getString("BI_CODE"));
//			suspenseDemandDTO.setAddlInfo(rs.getString("ADDL_INFO"));
//
//			suspenseDemandDTO.setOwnerName(rs.getString("NEW_OWNER"));
//			suspenseDemandDTO.setOwnerAddress(rs.getString("NEW_ADDRESS"));
//			suspenseDemandDTO.setWardNo(rs.getString("ASMT_WARD_NO"));
//			suspenseDemandDTO.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			suspenseDemandDTO.setPersonLiable(rs.getString("ASMT_PERSON_LIABLE"));
//			suspenseDemandDTO.setStreetName(rs.getString("COM_STREET_NAME"));
//
//			return suspenseDemandDTO;
//
//		}// end of method
//
//	}
//
//	private static final class SuspensePaymentDetailsRowMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			SuspenseDemandDTO suspenseDemandDTO = new SuspenseDemandDTO();
//			suspenseDemandDTO.setDemandNo(rs.getString("DEMAND_NO"));
//			suspenseDemandDTO.setAssesseeNo(rs.getString("ASSNO"));
//			suspenseDemandDTO.setApplicantName(rs.getString("APPLICANT_NAME"));
//			suspenseDemandDTO.setAddress(rs.getString("ADDRESS"));
//			suspenseDemandDTO.setEmail("EMAIL");
//			suspenseDemandDTO.setPaymentType(rs.getString("PAYMET_TYPE"));
//			suspenseDemandDTO.setAmount(rs.getString("AMOUNT"));
//			suspenseDemandDTO.setPaymentFlag(rs.getString("PAYMENT_FLAG"));
//
//			suspenseDemandDTO.setMobileNo(rs.getString("MOBILE_NO"));
//			suspenseDemandDTO.setPaymentDesc(rs.getString("PAYMENT_DESC"));
//			suspenseDemandDTO.setBiCode(rs.getString("BI_CODE"));
//
//			return suspenseDemandDTO;
//		}
//	}
//
//	private static final class AssessmentARRowMapper implements RowMapper {
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			AssesseeRoDto assesseeRoDto = new AssesseeRoDto();
//
//			assesseeRoDto.setAssesseeWardNo(rs.getString("asmt_ward_no"));
//			assesseeRoDto.setStreetCode(rs.getString("asmt_street_code"));
//			assesseeRoDto.setAssesseePremNo(rs.getString("asmt_prem_no"));
//			assesseeRoDto.setAssesseeStreetName(rs.getString("com_street_name"));
//			assesseeRoDto.setAssesseeBoroughNo(rs.getString("com_borough_no"));
//			assesseeRoDto.setAssesseeNo(rs.getString("asmt_assno"));
//			assesseeRoDto.setAssesseeNathi(rs.getString("asmt_nathi"));
//			assesseeRoDto.setNoOfStories(rs.getString("asmt_no_of_stories"));
//			assesseeRoDto.setNatureOfUse(rs.getString("asmt_nature_of_use"));
//			assesseeRoDto.setSuperbuildSpace(rs.getString("asmt_superbuilt_space"));
//			assesseeRoDto.setTotalCoveredSpace(rs.getString("asmt_total_covered_space"));
//			assesseeRoDto.setTotalCommonSpace(rs.getString("asmt_total_common_space"));
//			assesseeRoDto.setAssementQtr(rs.getString("asmt_effective_qtr"));
//			assesseeRoDto.setSupUnit(rs.getString("sup_unit"));
//			assesseeRoDto.setCovUnit(rs.getString("cov_unit"));
//			assesseeRoDto.setComUnit(rs.getString("com_unit"));
//
//			return assesseeRoDto;
//
//		}// end of method
//
//	}
//
//	private static final class ArHistoryMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AssesseeHistoryDTO assesseeHistoryDTO = new AssesseeHistoryDTO();
//			try {
//				assesseeHistoryDTO.setColumn(rs.getString("col"));
//				assesseeHistoryDTO.setAssesseeNo(rs.getString("asmt_assno"));
//				assesseeHistoryDTO.setAssessmentAv(rs.getString("asmt_av"));
//				assesseeHistoryDTO.setAssessmentRate(rs.getString("asmt_rate"));
//				assesseeHistoryDTO.setAssessmentQtrTax(rs.getString("asmt_qtrtax"));
//				assesseeHistoryDTO.setAssessmentHbt(rs.getString("asmt_hbt"));
//				assesseeHistoryDTO.setAssessmentSurcharge(rs.getString("asmt_surcharge"));
//				assesseeHistoryDTO.setPaybleAmount(rs.getString("asmt_payable_amt"));
//				assesseeHistoryDTO.setComRate(rs.getString("commrate"));
//				assesseeHistoryDTO.setRebate(rs.getString("rebate"));
//				assesseeHistoryDTO.setHearingDate(rs.getString("hearing_date"));
//				assesseeHistoryDTO.setGeneralRebate(rs.getString("generalRebate"));
//				assesseeHistoryDTO.setNetAmount(rs.getString("netAmt"));
//				assesseeHistoryDTO.setEffectDate(rs.getString("effect_date"));
//				assesseeHistoryDTO.setQtr(rs.getString("qtr"));
//				assesseeHistoryDTO.setRemarks(rs.getString("remark"));
//			} catch (Exception ex) {
//				ex.printStackTrace();
//
//			}
//			return assesseeHistoryDTO;
//		}
//	}
//
//	///////////////// somenath 26012020
//	private static final class MUTACertMapper implements RowMapper {
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			MUTACertDTO mutaCertDto = new MUTACertDTO();
//
//			mutaCertDto.setAsmtNature(rs.getString("asmt_nature_of_use"));
//			mutaCertDto.setApproveDate(rs.getString("APPROVEDATE"));
//			mutaCertDto.setPremNo(rs.getString("prem_no"));
//			mutaCertDto.setAssesseeNo(rs.getString("asmt_assno"));
//			mutaCertDto.setFlatNo(rs.getString("asmt_flat_no"));
//			mutaCertDto.setRegDtls(rs.getString("asmt_registration_dtls"));
//			mutaCertDto.setMutaAddr(rs.getString("MUTAADDR"));
//			mutaCertDto.setMutaOwn(rs.getString("MUTAOWNER"));
//			mutaCertDto.setPinCode(rs.getString("ASMT_N_PIN_CODE"));
//			mutaCertDto.setCaseNo(rs.getString("asmt_case_no"));
//
//			return mutaCertDto;
//
//		}// end of method
//	}
//
//	private static final class ArLandMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AssessmentMultiple assessmentMultiple = new AssessmentMultiple();
//			try {
//				assessmentMultiple.setLandArea(rs.getString("land_area"));
//
//			} catch (Exception ex) {
//				ex.printStackTrace();
//
//			}
//			return assessmentMultiple;
//		}
//	}
//
//	private static final class ArNameAddressMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AssessmentMultiple assessmentMultiple = new AssessmentMultiple();
//			try {
//				assessmentMultiple.setOwnerName(rs.getString("owner_name"));
//				assessmentMultiple.setOwnerAddress(rs.getString("owner_address"));
//				assessmentMultiple.setPersonLiable(rs.getString("liable"));
//			} catch (Exception ex) {
//				ex.printStackTrace();
//
//			}
//			return assessmentMultiple;
//		}
//	}
//
//	private static final class ArEffectiveQtrMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AssessmentMultiple assessmentMultiple = new AssessmentMultiple();
//			try {
//				assessmentMultiple.setEffectiveQtr(rs.getString("ASMT_EFFECTIVE_QTR"));
//				assessmentMultiple.setAsmtAv(rs.getString("asmt_av"));
//			} catch (Exception ex) {
//				ex.printStackTrace();
//
//			}
//			return assessmentMultiple;
//		}
//	}
//
//	private static final class ArHeritageMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AssessmentMultiple assessmentMultiple = new AssessmentMultiple();
//			try {
//				assessmentMultiple.setIsHeritage(rs.getString("IS_HERITAGE"));
//				assessmentMultiple.setIsPond(rs.getString("IS_POND"));
//			} catch (Exception ex) {
//				ex.printStackTrace();
//
//			}
//			return assessmentMultiple;
//		}
//	}
//
//	/**
//	 * 
//	 * @param dataSourceAssessment
//	 */
//	// ADDED BY SOUGATA ON 01.03.2010
//	private static final class AssesseeRowMapper implements RowMapper {
//
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			KMCAssementAssessDtlDTO asmtDTO = (KMCAssementAssessDtlDTO) DTOFactory
//					.createDTO("com.kmc.mas.mtps.assessment.dto.KMCAssementAssessDtlDTO");
//			asmtDTO.setAdd1(rs.getString("ASMT_ADRS_1"));
//			asmtDTO.setAdd2(rs.getString("ASMT_ADRS_2"));
//			asmtDTO.setAdd3(rs.getString("ASMT_ADRS_3"));
//			asmtDTO.setAdd4(rs.getString("ASMT_ADRS_4"));
//			asmtDTO.setAdd5(rs.getString("ASMT_ADRS_5"));
//			asmtDTO.setAdd6(rs.getString("ASMT_ADRS_6"));
//			asmtDTO.setAdd7(rs.getString("ASMT_ADRS_6"));
//			asmtDTO.setAdd8(rs.getString("ASMT_ADRS_8"));
//			asmtDTO.setAsmtPin(rs.getString("PIN_CODE"));
//			asmtDTO.setAsmtOwn1(rs.getString("OWNER"));
//			asmtDTO.setAsmtOwn2(rs.getString("ASMT_OWN_2"));
//			asmtDTO.setAsmtOwn3(rs.getString("ASMT_OWN_3"));
//			asmtDTO.setAsmtOwn4(rs.getString("ASMT_OWN_4"));
//			asmtDTO.setAsmtOwn5(rs.getString("ASMT_OWN_5"));
//			asmtDTO.setAsmtOwn6(rs.getString("ASMT_OWN_6"));
//			asmtDTO.setAsmtOwn7(rs.getString("ASMT_OWN_7"));
//			asmtDTO.setAsmtOwn8(rs.getString("ASMT_OWN_8"));
//			asmtDTO.setAsmtOwn9(rs.getString("ASMT_OWN_9"));
//			asmtDTO.setAsmtOwn10(rs.getString("ASMT_OWN_10"));
//			asmtDTO.setPremNo(rs.getString("PRST"));
//			asmtDTO.setPersonLiable(rs.getString("PERSON_LIABLE"));
//			asmtDTO.setAsmtSource(rs.getString("ASMT_STATUS"));
//			return asmtDTO;
//
//		}// end of method
//
//	}
//	// END OF ADDED ON 01.03.2010
//
//	// waiver 2020
//
//	private static final class AssesseeWaiverRowMapper implements RowMapper {
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			AssesseeWaiverDto assesseeWaiverDto = new AssesseeWaiverDto();
//
//			assesseeWaiverDto.setAssesseeNo(rs.getString("asmt_assno"));
//			assesseeWaiverDto.setApplicationNo(rs.getString("asmt_appln_no"));
//			assesseeWaiverDto.setApplicationDate(rs.getString("asmt_appln_dt"));
//			assesseeWaiverDto.setApplicationStatus(rs.getString("asmt_status"));
//			assesseeWaiverDto.setAssesseeWardNo(rs.getString("asmt_ward_no"));
//			assesseeWaiverDto.setApplicantName(rs.getString("asmt_applicant_nm"));
//			assesseeWaiverDto.setApprovalDate(rs.getString("mayer_apprvl_dt"));
//			assesseeWaiverDto.setWaiverDueDate(rs.getString("asmt_due_dt"));
//			assesseeWaiverDto.setApplicationStatusId(rs.getString("asmt_status_id"));
//			assesseeWaiverDto.setInterestWaived(rs.getString("asmt_interest_wv"));
//			assesseeWaiverDto.setPenaltyWaived(rs.getString("asmt_penalty_wv"));
//			assesseeWaiverDto.setPaybleWaived(rs.getString("asmt_payable_wv"));
//			assesseeWaiverDto.setRemark(rs.getString("remarks"));
//			assesseeWaiverDto.setInterestAmount(rs.getString("asmt_int_amt"));
//			assesseeWaiverDto.setPenaltyAmount(rs.getString("asmt_penalty_amt"));
//			assesseeWaiverDto.setPaybleAmount(rs.getString("asmt_payable_amt"));
//			assesseeWaiverDto.setMobileNo(rs.getString("asmt_mob_no"));
//			assesseeWaiverDto.setSchemeId(rs.getString("scheme_id"));
//			assesseeWaiverDto.setSuspenseAmount(rs.getString("suspenseamount"));
//
//			return assesseeWaiverDto;
//
//		}// end of method
//
//	}
//
//	private static final class AsseRowMapper implements RowMapper {
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AssesseeWaiverDto assesseeWaiverDto = new AssesseeWaiverDto();
//
//			assesseeWaiverDto.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			assesseeWaiverDto.setPremisesNo(rs.getString("PREMISES"));
//			assesseeWaiverDto.setApplicantName(rs.getString("OWNER"));
//			assesseeWaiverDto.setApplicantAddress(rs.getString("ADDRESS"));
//			assesseeWaiverDto.setAssesseeWardNo(rs.getString("WARD"));
//			assesseeWaiverDto.setApplicationDate(rs.getString("APPLICATIONDATE"));
//			assesseeWaiverDto.setWaiverDueDate(rs.getString("WAIVERDUEDATE"));
//			assesseeWaiverDto.setApprovalDate(rs.getString("APPROVEDATE"));
//
//			return assesseeWaiverDto;
//
//		}// end of method
//
//	}
//
//	// waiver 2020 end
//
//	private static final class CallPenaltyAmtProc extends StoredProcedure {
//		private static final String STORED_PROC_NAME = "ASMT_P_PENALTY";
//
//		public CallPenaltyAmtProc(DataSource ds) {
//			super(ds, STORED_PROC_NAME);
//
//			declareParameter(new SqlParameter("p_demandAmt", Types.FLOAT));
//			declareParameter(new SqlParameter("p_quarter", Types.VARCHAR));
//			declareParameter(new SqlOutParameter("po_penalty", Types.DOUBLE));
//			declareParameter(new SqlOutParameter("po_message", Types.VARCHAR));
//			compile();
//		}
//
//		public void execute(String demandAmount, String qtr, String penaltyAmt, String mesg, HashMap retMap) {
//
//			Map inParams = new HashMap(4);
//			inParams.put("p_demandAmt", demandAmount);
//			inParams.put("p_quarter", qtr);
//			inParams.put("po_penalty", penaltyAmt);
//			inParams.put("po_message", mesg);
//			Map outParams = execute(inParams);
//			if (outParams.size() > 0) {
//				double _dbl = 0;
//				Double _dblamt = (Double) outParams.get("po_penalty");
//
//				if (_dblamt != null)
//					_dbl = _dblamt.doubleValue();
//				BigDecimal bdPenaltyAmount = new BigDecimal(_dbl);
//				bdPenaltyAmount = bdPenaltyAmount.setScale(2, BigDecimal.ROUND_DOWN);
//				retMap.put("penaltyAmount", bdPenaltyAmount);
//				retMap.put("message", (String) outParams.get("po_message"));
//			}
//
//		}
//	}
//
//	private static final class CallInterestAmtProc extends StoredProcedure {
//		private static final String STORED_PROC_NAME = "ASMT_P_INTEREST_PORTAL";
//
//		public CallInterestAmtProc(DataSource ds) {
//			super(ds, STORED_PROC_NAME);
//
//			declareParameter(new SqlParameter("p_demandAmt", Types.FLOAT));
//			declareParameter(new SqlParameter("p_av", Types.FLOAT));
//			declareParameter(new SqlParameter("p_outstandingDate", Types.VARCHAR));
//			declareParameter(new SqlParameter("p_currdate", Types.VARCHAR));
//			declareParameter(new SqlOutParameter("po_penalty", Types.FLOAT));
//			declareParameter(new SqlOutParameter("po_message", Types.VARCHAR));
//			compile();
//		}
//
//		public void execute(String demandAmount, String annualValuation, String outStandingDate, String todayDate,
//				String intAmt, String mesg, HashMap retMap) {
//
//			Map inParams = new HashMap(6);
//			inParams.put("p_demandAmt", demandAmount);
//			inParams.put("p_av", annualValuation);
//			inParams.put("p_outstandingDate", outStandingDate);
//			inParams.put("p_currdate", todayDate);
//			inParams.put("po_penalty", intAmt);
//			inParams.put("po_message", mesg);
//
//			Map outParams = execute(inParams);
//			if (outParams.size() > 0) {
//				double _dbl = 0;
//				Double _dblamt = (Double) outParams.get("po_penalty");
//				if (_dblamt != null)
//					_dbl = _dblamt.doubleValue();
//				BigDecimal interestAmount = new BigDecimal(_dbl);
//				interestAmount = interestAmount.setScale(2, BigDecimal.ROUND_DOWN);
//				retMap.put("interestAmount", interestAmount);
//				retMap.put("message", (String) outParams.get("po_message"));
//			}
//
//		}
//	}
//
//	public void setDataSourceAssessment(DataSource dataSourceAssessment) {
//		this.dataSourceAssessment = dataSourceAssessment;
//		this.jdbcTemplate = new JdbcTemplate(dataSourceAssessment);
//	}
//
//	public DataSource getDataSourceAssessment() {
//		return dataSourceAssessment;
//	}
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//
//	}
//
//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//
//	public KMCPortalServiceReturnObject getDemandDetailsForCurrentYear(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		System.out.println("assesseeno::" + _assesseeNo);
//		System.out.println("wardNo=" + wardNo);
//
//		AssessmentCurrentRowMapper _rowmapper = new AssessmentCurrentRowMapper();
//		List retList = new ArrayList();
//		String sqlQuery = KMCAssessmentConstants.getCurrentDemandForAssess();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo }, _rowmapper);
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid F-S Bill exist for the given assessee");
//			throw _busException;
//
//		}
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public List checkForFSBill(String datToday, String assesseeNo, String userDefBillNo, String currentQtr,
//			HashMap fsBill, List searchedDataList, String billingQtr) {
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		PreparedStatement psPayableAmt = null;
//		ResultSet rsPayableAmt = null;
//		ResultSet rs = null;
//		try {
//			conn = jdbcTemplate.getDataSource().getConnection();
//			String physicalBillNo = "";
//			String grossAmt = "";
//			String rebateDate = "";
//			BigDecimal rebateAmt = new BigDecimal(0);
//			BigDecimal netAmount = new BigDecimal(0);
//			BigDecimal netAmountTotal = new BigDecimal(0);
//			BigDecimal rebateAmtTotal = new BigDecimal(0);
//			String indiPayableAmt = "";
//			int noOfQtrs = 0;
//			BigDecimal totalRebateAmt = new BigDecimal(0);
//			BigDecimal totalNetAmount = new BigDecimal(0);
//			StringBuffer strBuf = new StringBuffer(" select distinct asmt_share_type,ASMT_FS_BILL_NO, ");
//			strBuf.append(" to_char(asmt_presentation_date,'dd/mm/yyyy')asmt_presentation_date, ");
//			strBuf.append(
//					" asmt_bill_type,(select distinct MIN(asmt_billed_qtr) from ASMT_DEMAND b where ASMT_ASSNO=? AND ASMT_WARD_NO=?");
//			strBuf.append(" and ASMT_FS_BILL_NO=? and asmt_bill_status='B' group by asmt_share_type)asmt_from_qtr, ");
//			strBuf.append(
//					" (select distinct MAX(asmt_billed_qtr) from ASMT_DEMAND b where ASMT_ASSNO=? AND ASMT_WARD_NO=?");
//			strBuf.append(" and ASMT_FS_BILL_NO=? and asmt_bill_status='B' group by asmt_share_type)asmt_to_qtr, ");
//			strBuf.append(
//					" (select distinct sum(ROUND(asmt_payable_amt,0)) from ASMT_DEMAND where ASMT_ASSNO=? AND ASMT_WARD_NO=? and ASMT_FS_BILL_NO=? and asmt_bill_status='B' group by asmt_share_type)asmt_payable_amt , ");
//			strBuf.append(" to_char(asmt_rebate_date,'dd/mm/yyyy')asmt_rebate_date from ASMT_DEMAND ");
//			strBuf.append(" where asmt_assno=? AND ASMT_WARD_NO=? and asmt_bill_status='B' and ASMT_FS_BILL_NO=? ");
//			strBuf.append(" group by asmt_share_type,ASMT_FS_BILL_NO,asmt_presentation_date,asmt_bill_type, ");
//			strBuf.append(
//					" asmt_billed_qtr,asmt_payable_amt,asmt_rebate_date  order by asmt_presentation_date,asmt_from_qtr");
//			if (fsBill != null && !fsBill.containsKey(userDefBillNo)) {
//
//				psPayableAmt = conn.prepareStatement(KMCAssessmentConstants.getRoundedDemandNo());
//				ps = conn.prepareStatement(strBuf.toString());
//				ps.setString(1, assesseeNo);
//				ps.setString(2, assesseeNo.substring(2, 5));
//				ps.setString(3, userDefBillNo);
//				ps.setString(4, assesseeNo);
//				ps.setString(5, assesseeNo.substring(2, 5));
//				ps.setString(6, userDefBillNo);
//				ps.setString(7, assesseeNo);
//				ps.setString(8, assesseeNo.substring(2, 5));
//				ps.setString(9, userDefBillNo);
//				ps.setString(10, assesseeNo);
//				ps.setString(11, assesseeNo.substring(2, 5));
//				ps.setString(12, userDefBillNo);
//				rs = ps.executeQuery();
//				while (rs.next()) {
//
//					physicalBillNo = rs.getString("ASMT_FS_BILL_NO");
//					grossAmt = rs.getString("asmt_payable_amt");
//					DemandCollectionDTO demandCollectionDTO = new DemandCollectionDTO();
//					demandCollectionDTO.setBillNo(physicalBillNo);
//					demandCollectionDTO.setPhysicalBillNo(physicalBillNo);
//					demandCollectionDTO.setPresentationDate(rs.getString("asmt_presentation_date"));
//					demandCollectionDTO.setBillType(rs.getString("asmt_bill_type"));
//					demandCollectionDTO.setFromQtr(
//							KMCAssessmentUtility.convertEffQuarterFromStorageToView(rs.getString("asmt_from_qtr")));
//					demandCollectionDTO.setToQtr(
//							KMCAssessmentUtility.convertEffQuarterFromStorageToView(rs.getString("asmt_to_qtr")));
//					demandCollectionDTO.setGrossAmount(grossAmt);
//					demandCollectionDTO.setShareType(rs.getString("asmt_share_type"));
//					demandCollectionDTO.setSelectAll("");
//					demandCollectionDTO.setSelectFlag("");
//					demandCollectionDTO.setClubbedBill("YES");
//					demandCollectionDTO.setUserDefBillNo(rs.getString("ASMT_FS_BILL_NO"));
//					rebateDate = rs.getString("asmt_rebate_date");
//					rebateDate = getValidWorkingDay(rebateDate);
//					demandCollectionDTO.setRebateDate(rebateDate);
//					String outStandingDate = KMCAssessmentUtility.getOutstandingDateOfStorageQtr(billingQtr);
//					demandCollectionDTO.setOutStandingDate(outStandingDate);
//					if (UtilityForAll.compareDates(datToday, rebateDate) != 1) {
//						psPayableAmt.setString(1, physicalBillNo);
//						psPayableAmt.setString(2, assesseeNo.substring(2, 5));
//						psPayableAmt.setString(3, assesseeNo);
//						psPayableAmt.setString(4, rs.getString("asmt_share_type"));
//						rsPayableAmt = psPayableAmt.executeQuery();
//						netAmountTotal = new BigDecimal(0);
//						rebateAmtTotal = new BigDecimal(0);
//						while (rsPayableAmt.next()) {
//							indiPayableAmt = rsPayableAmt.getString("asmt_payable_amt");
//							rebateAmt = new BigDecimal(indiPayableAmt).multiply(new BigDecimal(0.05));
//							rebateAmt = rebateAmt.setScale(2, BigDecimal.ROUND_DOWN);
//							netAmount = new BigDecimal(indiPayableAmt).subtract(rebateAmt);
//							netAmount = netAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//							netAmountTotal = netAmountTotal.add(netAmount);
//							rebateAmtTotal = rebateAmtTotal.add(rebateAmt);
//							demandCollectionDTO.setNetAmount(String.valueOf(netAmountTotal));
//							demandCollectionDTO.setRebateAmount(String.valueOf(rebateAmtTotal));
//						}
//					} else {
//						demandCollectionDTO.setNetAmount(grossAmt);
//						demandCollectionDTO.setRebateAmount("0.0");
//					}
//					fsBill.put(userDefBillNo, demandCollectionDTO);
//					searchedDataList.add(demandCollectionDTO);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//
//				if (ps != null)
//					ps.close();
//				if (psPayableAmt != null)
//					psPayableAmt.close();
//				if (rsPayableAmt != null)
//					rsPayableAmt.close();
//				if (rs != null)
//					rs.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//
//			}
//
//		}
//		return searchedDataList;
//
//	}
//
//	public String getValidWorkingDay(String date) {
//		boolean validDate = false;
//		String day = getDayOfAYear(date);
//		if (day.equalsIgnoreCase("Sunday")) {
//			validDate = false;
//		} else {
//			String reason = getHolidayReason(date);
//			if (reason != null) {
//				validDate = false;
//			} else {
//				validDate = true;
//				// break;
//			}
//		}
//		if (!validDate) {
//			date = KMCAssessmentUtility.addDaysToDate(date, 1);
//		}
//
//		return date;
//	}
//
//	public String getHolidayReason(String date) {
//		int holidayReason = 0;
//		String query = " SELECT count(1) FROM  asmt_holiday_list  WHERE ASMT_DAY = TO_DATE(?,'DD/MM/YYYY')";
//		holidayReason = jdbcTemplate.queryForInt(query, new Object[] { date });
//		if (holidayReason == 0)
//			return null;
//		else
//			return "HAS";
//	}
//
//	public String getDayOfAYear(String inpDate) {
//
//		String query = "select to_char(to_date(?,'dd/mm/yyyy'),'Day') as tempDate from dual ";
//		String SatSunday = (String) jdbcTemplate.queryForObject(query, new Object[] { inpDate }, String.class);
//		return SatSunday;
//	}
//
//	public void getPenaltyAmount(HashMap penaltyQueryMap) {
//		String demandAmount = (String) penaltyQueryMap.get("demandAmount");
//		String qtr = (String) penaltyQueryMap.get("qtr");
//		String todayDate = (String) penaltyQueryMap.get("todayDate");
//		CallPenaltyAmtProc proc = new CallPenaltyAmtProc(dataSourceAssessment);
//		String amt = "0.0";
//		String message = "";
//		proc.execute(demandAmount, qtr, amt, message, penaltyQueryMap);
//	}
//
//	public void getInterestAmount(HashMap interestQueryMap) {
//		String demandAmount = (String) interestQueryMap.get("demandAmount");
//		String annualValuation = (String) interestQueryMap.get("annualValuation");
//		String outStandingDate = (String) interestQueryMap.get("outStandingDate");
//		String todayDate = (String) interestQueryMap.get("todayDate");
//		CallInterestAmtProc proc = new CallInterestAmtProc(dataSourceAssessment);
//		String messg = "";
//		String amt = "0.0";
//		proc.execute(demandAmount, annualValuation, outStandingDate, todayDate, amt, messg, interestQueryMap);
//	}
//
//	public KMCPortalServiceReturnObject getDemandDetailsForOutStandingCollection(HashMap infoMap)
//			throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String schemeType = (String) infoMap.get("SCHEMETYPE");
//		String wardNo = _assesseeNo.substring(2, 5);
//		AssessmentCurrentRowMapper _outRowmapper = new AssessmentCurrentRowMapper();
//		List retList = new ArrayList();
//		String sqlQuery = "";
//		String todate = UtilityForAll.getTodaysDate();
//		String year = KMCAssessmentUtility.getCurrentFinYear();
//		int waiverCount = 0;
//		int ApplCount = 0;
//
//		try {
//			ApplCount = isApprovedApplicationExists(_assesseeNo);
//			waiverCount = isWaiverExists(_assesseeNo, wardNo, todate, year.substring(0, 4));
//		} catch (Exception e) {
//
//		}
//
//		if (schemeType != null && (schemeType.equals("WAIVER") || schemeType.equals("WAIVER60"))) {
//			if (ApplCount == 0) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("No Approved Waiver Application exist.");
//				throw _busException;
//			}
//
//			sqlQuery = KMCAssessmentConstants.getOutStandingDemandForAssessWaiver();
//			System.out.println("*************getOutStandingDemandForAssessWaiver =" + sqlQuery);
//		} else {
//
//			/*
//			 * if(ApplCount>0 && waiverCount > 0) { KMCPortalBusinessException _busException
//			 * = new KMCPortalBusinessException(); _busException.
//			 * setErrMesg("Waiver Application exist. Please Pay the Waiver Demand First");
//			 * throw _busException; }
//			 */
//			sqlQuery = KMCAssessmentConstants.getOutStandingDemandForAssess();
//			System.out.println("*************getOutStandingDemandForAssess =" + sqlQuery);
//		}
//
//		retList = jdbcTemplate.query(sqlQuery,
//				new Object[] { _assesseeNo, wardNo, todate, _assesseeNo, wardNo, year.substring(0, 4) }, _outRowmapper);
//
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No outstanding demand exist for the given assessee");
//			throw _busException;
//		}
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public KMCPortalServiceReturnObject getDemandDetailsForCurrentPD(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		String sqlQuery = KMCAssessmentConstants.getCurrentPDForAssess();
//		AssessmentCurrentRowMapper _outRowmapper = new AssessmentCurrentRowMapper();
//		List retList = new ArrayList();
//		String todate = UtilityForAll.getTodaysDate();
//		String year = KMCAssessmentUtility.getCurrentFinYear();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo, year.substring(0, 4) },
//				_outRowmapper);
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid property tax demand exist for the given assessee for current year");
//			throw _busException;
//		}
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public KMCPortalServiceReturnObject getDemandDetailsForSuspense(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("*************Enter getDemandDetailsForSuspense =");
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _demandNo = (String) infoMap.get("DEMANDNO");
//
//		String sqlQuery = KMCAssessmentConstants.getSuspenseDemandDtl();
//		SuspensePaymentRowMapper _outRowmapper = new SuspensePaymentRowMapper();
//		List retList = new ArrayList();
//		System.out.println("*************Enter _demandNo =" + _demandNo);
//		System.out.println("*************Enter sqlQuery =" + sqlQuery);
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _demandNo }, _outRowmapper);
//		System.out.println("************* retList =" + retList.size());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Validate fails.Plese Try again");
//			throw _busException;
//		}
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public String insertDemandDetailsForSuspense(HashMap infoMap) throws Exception {
//		String seqName = "MISC_SUSP_SEQ";
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		Connection conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//		PreparedStatement ps = null;
//		String _assesseeNo = (String) infoMap.get("ASSESSEENO");
//		System.out.println("*************Enter _assesseeNo =" + _assesseeNo);
//		String _name = (String) infoMap.get("NAME");
//		String _address = (String) infoMap.get("ADDRESS");
//		String _mobileNo = (String) infoMap.get("MOBILENO");
//		String _email = (String) infoMap.get("EMAILID");
//		String _amount = (String) infoMap.get("AMOUNT");
//		String _paymentType = (String) infoMap.get("PAYMENTTYPE");
//		String _paymentDesc = (String) infoMap.get("PAYMENTDESC");
//		String _paymentBiCode = (String) infoMap.get("BICODE");
//		String _addlInfo = (String) infoMap.get("ADDLINFO");
//		String _userId = (String) infoMap.get("USERID");
//		String _demandNo = "";
//		try {
//			if (_paymentType.equals("ASSESSMENT SUSPENSE")) {
//				_paymentBiCode = getBiCodeFromAssessee(_assesseeNo);
//			}
//			System.out.println("*************Enter insert =");
//			_demandNo = generateSequenceForSuspense(seqName);
//			System.out.println("*************_demandNo suspense =" + _demandNo);
//			String insertStatement = " insert into miscellaneous_suspense_demand (DEMAND_NO, ASSNO, APPLICANT_NAME, ADDRESS, MOBILE_NO, EMAIL, PAYMET_TYPE, AMOUNT, PAYMENT_FLAG, CREATE_UID, CREATE_DATE,PAYMENT_DESC,BI_CODE,ADDL_INFO) values (?,?,upper(?),upper(?),?,?,?,?,'I',?, sysdate,?,?,?) ";
//
//			ps = conn.prepareStatement(insertStatement);
//			ps.setString(1, _demandNo);
//			ps.setString(2, _assesseeNo);
//			ps.setString(3, _name);
//			ps.setString(4, _address);
//			ps.setString(5, _mobileNo);
//			ps.setString(6, _email);
//			ps.setString(7, _paymentType);
//			ps.setString(8, _amount);
//			ps.setString(9, _userId);
//			ps.setString(10, _paymentDesc);
//			ps.setString(11, _paymentBiCode);
//			ps.setString(12, _addlInfo);
//			ps.executeUpdate();
//			System.out.println("*************insert finish =");
//
//		} finally {
//			if (ps != null)
//				ps.close();
//			if (conn != null)
//				conn.close();
//		}
//
//		return _demandNo;
//
//	}
//
//	public String generateSequenceForSuspense(String seqName) throws Exception {
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		Connection conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//		PreparedStatement ps = null;
//
//		CallableStatement csUpdate = null;
//		CallableStatement csInsert = null;
//
//		ResultSet rs = null;
//		String demandNo = "";
//		// "P" + UtilityForAll.getCurrentFinYear() +
//		// UtilityForAll.lpad(boroughNo,2,'0');
//		HashMap receiptSeqGen = new HashMap();
//		try {
//
//			String selectStatement = " SELECT WS_SEQ_NO FROM WS_CONN_SANCTION_SEQUENCE T WHERE WS_SEQ_NAME = ? and t.ws_office_cd='9999' ";
//			String updateStatement = " UPDATE_WS_SANCTION_SEQUENCE(?)  ";
//			String insertTab = " INSERT_WS_SANCTION_SEQUENCE(?,?) ";
//			ps = conn.prepareStatement(selectStatement);
//			ps.setString(1, seqName);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				demandNo = rs.getString(1);
//			}
//			if (!"".equals(demandNo)) {
//				csUpdate = conn.prepareCall("{call " + updateStatement + "}");
//				csUpdate.setString(1, seqName);
//				csUpdate.executeUpdate();
//			} else {
//				csInsert = conn.prepareCall("{call " + insertTab + "}");
//				csInsert.setString(1, seqName);
//				csInsert.setString(2, "2");
//				csInsert.executeUpdate();
//				demandNo = demandNo + "1";
//
//			}
//		} finally {
//			if (ps != null)
//				ps.close();
//			if (csUpdate != null)
//				csUpdate.close();
//			if (csInsert != null)
//				csInsert.close();
//			if (conn != null)
//				conn.close();
//		}
//		return demandNo;
//	}
//
//	// Added by Dipankar for Assessee status checking during online payment
//	public KMCPortalServiceReturnObject getDemandForPayment(HashMap infoMap) throws KMCPortalBusinessException {
//		if (log.isDebugEnabled()) {
//			log.debug("Entering getDemandForPayment method of KMCPortalAssessmentDAO");
//		}
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String sqlQuery = KMCAssessmentConstants.CHECK_ASSESSESS_STATUS();
//
//		AssesseeStatusRowMapper _outRowmapper = new AssesseeStatusRowMapper();
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, _outRowmapper);
//
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Invalid Assessee Number");
//			throw _busException;
//		} else {
//			KMCAssementAssessDtlDTO assessmentDTO = (KMCAssementAssessDtlDTO) retList.get(0);
//			String status = assessmentDTO.getAssesseeStatus();
//
//			if (log.isDebugEnabled()) {
//				log.debug("Status of the assessee : " + status);
//			}
//
//			if ("C".equals(status) || "X".equals(status)) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("Payment is not allowed - please contact Assessment department for details");
//				throw _busException;
//
//			} else {
//
//				if (log.isDebugEnabled()) {
//					log.debug("Redirecting to normal flow....");
//				}
//				return getDemandDetailsForCurrentPD(infoMap);
//			}
//		}
//	}
//
//	public KMCPortalServiceReturnObject insertSearchDtlsForSuspPayment(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		if (log.isDebugEnabled()) {
//			log.debug("Entering insertSearchDtlsForSuspPayment method of KMCPortalAssessmentDAO");
//		}
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSEENO");
//		String _userId = (String) infoMap.get("USERID");
//		String _paymentType = (String) infoMap.get("PAYMENTTYPE");
//		/*
//		 * String _assesseeNo = (String)infoMap.get("NAME"); String _assesseeNo =
//		 * (String)infoMap.get("ADDRESS"); String _assesseeNo =
//		 * (String)infoMap.get("MOBILENO"); String _assesseeNo =
//		 * (String)infoMap.get("EMAILID"); String _assesseeNo =
//		 * (String)infoMap.get("AMOUNT"); String _assesseeNo =
//		 * (String)infoMap.get("PAYMENTTYPE");
//		 */
//
//		if (_assesseeNo == null || _assesseeNo.equals("")) {
//
//		} else {
//			if (_paymentType.equals("ASSESSMENT SUSPENSE")) {
//				String sqlQuery = KMCAssessmentConstants.CHECK_ASSESSESS_STATUS();
//
//				AssesseeStatusRowMapper _outRowmapper = new AssesseeStatusRowMapper();
//				List retList = new ArrayList();
//				retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, _outRowmapper);
//
//				if (retList == null || retList.size() == 0) {
//					KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//					_busException.setErrMesg("Invalid Assessee Number");
//					throw _busException;
//				}
//			}
//		}
//		// else{
//
//		try {
//
//			if (_userId != null) {
//				String demandNo = insertDemandDetailsForSuspense(infoMap);
//				infoMap.put("DEMANDNO", demandNo);
//				System.out.println("*************After Insert =");
//			} else {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("Session Has Expired.Please Log In Again and Then Validate the Form.");
//				throw _busException;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return getDemandDetailsForSuspense(infoMap);
//
//		// }
//	}
//
//	public KMCPortalServiceReturnObject getSuspenseDetailsForDisplay(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		if (log.isDebugEnabled()) {
//			log.debug("Entering insertSearchDtlsForSuspPayment method of KMCPortalAssessmentDAO");
//		}
//
//		/*
//		 * KMCPortalServiceReturnObject _portalServiceReturnObject = new
//		 * KMCPortalServiceReturnObject();
//		 * 
//		 * return getDemandDetailsForSuspense(infoMap);
//		 */
//
//		System.out.println("*************Enter getSuspenseDetailsForDisplay =");
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _demandNo = (String) infoMap.get("DEMANDNO");
//
//		String sqlQuery = KMCAssessmentConstants.getSuspenseDemandDtl();
//		SuspensePaymentDetailsRowMapper _outRowmapper = new SuspensePaymentDetailsRowMapper();
//		List retList = new ArrayList();
//		System.out.println("*************Enter _demandNo =" + _demandNo);
//		System.out.println("*************Enter sqlQuery =" + sqlQuery);
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _demandNo }, _outRowmapper);
//		System.out.println("************* retList2222222222222 =" + retList.size());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Feching fails.Plese Try again");
//			throw _busException;
//		}
//
//		SuspenseDemandDTO _suspenseDemandDTO = (SuspenseDemandDTO) retList.get(0);
//		System.out.println(
//				"**************_suspenseDemandDTO.getApplicantName()=" + _suspenseDemandDTO.getApplicantName());
//		KMCPortalServiceReturnObject _serviceReturnObject = new KMCPortalServiceReturnObject();
//		HashMap returnMap = new HashMap();
//		returnMap.put("RETURN_DTO", _suspenseDemandDTO);
//
//		_serviceReturnObject.setReturnMap(returnMap);
//		// _portalServiceReturnObject.setObj(retList);
//		return _serviceReturnObject;
//
//	}
//
//	public KMCPortalServiceReturnObject getDemandDetailsForCurrentPDPrint(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		String sqlQuery = KMCAssessmentConstants.getCurrentPDPrintForAssess();
//		// System.out.println("sqlQuery::::::::::::::::"+sqlQuery);
//		AssessmentCurrentRowMapper _outRowmapper = new AssessmentCurrentRowMapper();
//		List retList = new ArrayList();
//		String todate = UtilityForAll.getTodaysDate();
//		String year = KMCAssessmentUtility.getCurrentFinYear();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo, year.substring(0, 4) },
//				_outRowmapper);
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid property tax demand exist for the given assessee for current year");
//			throw _busException;
//		}
//
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	////// Added by MICHAEL///////////////////////////////////////
//	///// ***********For Duplicate PD Bill Printing *************************//
//	//////////////////////////////////////////////////////////////////////////
//
//	public KMCPortalServiceReturnObject getARAssesseeDetailsPrint(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//		String sqlQuery = KMCAssessmentConstants.getARAssesseeDetails();
//		System.out.println("getARAssesseeDetails::::::::::::::::" + sqlQuery);
//
//		AssessmentARRowMapper assessmentARRowMapper = new AssessmentARRowMapper();
//
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _assesseeNo }, assessmentARRowMapper);
//
//		System.out.println("retList.size() of getARAssesseeDetails::::::::::::::::" + retList.size());
//
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid property tax demand exist for the given assessee for current year");
//			throw _busException;
//		}
//
//		HashMap historyMap = new HashMap();
//		HashMap landMap = new HashMap();
//		HashMap addressMap = new HashMap();
//		HashMap qtrMap = new HashMap();
//		HashMap heritageMap = new HashMap();
//		ArrayList _historyDetailsList = new ArrayList();
//		ArrayList _landDetailsList = new ArrayList();
//		ArrayList _addressList = new ArrayList();
//		ArrayList _qtrList = new ArrayList();
//		ArrayList _heritageList = new ArrayList();
//
//		System.out.println("getARAssesseeDetails:::11111111111");
//		historyMap = getHistoryDetails(infoMap);
//		_historyDetailsList = (ArrayList) historyMap.get("HISTORY_LIST");
//
//		System.out.println("getARAssesseeDetails:::22222222");
//
//		landMap = getLandDetails(infoMap);
//		_landDetailsList = (ArrayList) landMap.get("LAND_LIST");
//		AssessmentMultiple assessmentMultiple1 = new AssessmentMultiple();
//		assessmentMultiple1 = (AssessmentMultiple) _landDetailsList.get(0);
//		System.out.println("getARAssesseeDetails::3333333");
//
//		addressMap = getArAddressDetails(infoMap);
//		_addressList = (ArrayList) addressMap.get("ADDRESS_LIST");
//		AssessmentMultiple assessmentMultiple2 = new AssessmentMultiple();
//		assessmentMultiple2 = (AssessmentMultiple) _addressList.get(0);
//
//		System.out.println("getARAssesseeDetails:::44444444");
//
//		qtrMap = getEffectiveQtrDetails(infoMap);
//		_qtrList = (ArrayList) qtrMap.get("QTR_LIST");
//		AssessmentMultiple assessmentMultiple3 = new AssessmentMultiple();
//		assessmentMultiple3 = (AssessmentMultiple) _qtrList.get(0);
//		System.out.println("getARAssesseeDetails:::55555555");
//
//		heritageMap = getHeritageDetails(infoMap);
//		_heritageList = (ArrayList) heritageMap.get("HERITAGE_LIST");
//		AssessmentMultiple assessmentMultiple4 = new AssessmentMultiple();
//		assessmentMultiple4 = (AssessmentMultiple) _heritageList.get(0);
//		System.out.println("getARAssesseeDetails:::666666666");
//
//		AssesseeRoDto assesseeRoDto = new AssesseeRoDto();
//		assesseeRoDto = (AssesseeRoDto) retList.get(0);
//		System.out.println("getARAssesseeDetails:::77777777");
//		assesseeRoDto.setLandArea(assessmentMultiple1.getLandArea());
//		assesseeRoDto.setOwnerName(assessmentMultiple2.getOwnerName());
//		assesseeRoDto.setOwnerAddress(assessmentMultiple2.getOwnerAddress());
//		assesseeRoDto.setPersonLiable(assessmentMultiple2.getPersonLiable());
//		assesseeRoDto.setEffectiveQtr(assessmentMultiple3.getEffectiveQtr());
//		assesseeRoDto.setAsmtAv(assessmentMultiple3.getAsmtAv());
//		assesseeRoDto.setIsHeritage(assessmentMultiple4.getIsHeritage());
//		assesseeRoDto.setIsPond(assessmentMultiple4.getIsPond());
//		assesseeRoDto.setHistoryDetailsList(_historyDetailsList);
//		System.out.println("getARAssesseeDetails:::888888");
//		List mainList = new ArrayList();
//		mainList.add(assesseeRoDto);
//
//		System.out.println("****************IN ACTION=" + mainList.size());
//		System.out.println("****************assesseeRoDto=" + assesseeRoDto.getAssesseeNo());
//		System.out.println("****************assesseeRoDto::no of stories:::::::=" + assesseeRoDto.getNoOfStories());
//		_portalServiceReturnObject.setObj(mainList);
//		return _portalServiceReturnObject;
//	}
//
//	///////////// somenath 26012020//////////
////      
//
//	/*
//	 * public KMCPortalServiceReturnObject getMUTAcertPrint(HashMap infoMap) throws
//	 * KMCPortalBusinessException { KMCPortalServiceReturnObject
//	 * _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//	 * 
//	 * String _assesseeNo = (String)infoMap.get("ASSESSENO"); String _caseNo =
//	 * (String)infoMap.get("CASENO");
//	 * 
//	 * StringBuffer _sbQuery1 = new
//	 * StringBuffer("select A.asmt_assno, nvl(to_char(B.ASMT_APPROVE_DATE,'DD/MM/YYYY'),' ') APPROVEDATE, B.ASMT_N_PIN_CODE, B.ASMT_N_OWN_1 || B.ASMT_N_OWN_2 || "
//	 * ); _sbQuery1.
//	 * append(" B.ASMT_N_OWN_3 || B.ASMT_N_OWN_4 || B.ASMT_N_OWN_5 || B.ASMT_N_OWN_6 || B.ASMT_N_OWN_7 || B.ASMT_N_OWN_8 || B.ASMT_N_OWN_9 || B.ASMT_N_OWN_10 MUTAOWNER, B.asmt_case_no,  "
//	 * ); _sbQuery1.
//	 * append(" B.ASMT_N_ADRS_1 | |B.ASMT_N_ADRS_2 || B.ASMT_N_ADRS_3 || B.ASMT_N_ADRS_4 || B.ASMT_N_ADRS_5 || B.ASMT_N_ADRS_6 || B.ASMT_N_ADRS_7 || B.ASMT_N_ADRS_8 MUTAADDR , "
//	 * ); _sbQuery1.
//	 * append(" a.asmt_registration_dtls, decode(nvl(asmt_flat_no,' '),' ',' ','Flat: '||asmt_flat_no) asmt_flat_no,a.asmt_prem_no||','||C.com_street_name prem_no, "
//	 * ); _sbQuery1.
//	 * append("  decode(a.asmt_nature_of_use,'',' ','Nature of Premise: '|| substr(a.asmt_nature_of_use,1,50)) asmt_nature_of_use "
//	 * ); _sbQuery1.
//	 * append(" from asmt_muta_case_dtl B,asmt_asse_mst a,com_street_mst C where   B.asmt_assno=? and B.asmt_case_no=? "
//	 * ); _sbQuery1.
//	 * append(" and a.asmt_ward_no=C.com_ward_no and to_number(a.asmt_street_code)=to_number(C.com_street_code) AND A.asmt_assno =B.asmt_assno   "
//	 * );
//	 * 
//	 * String sqlQuery = _sbQuery1.toString();
//	 * 
//	 * System.out.println("sql query="+sqlQuery);
//	 * 
//	 * MUTACertMapper mutaCertMapper = new MUTACertMapper();
//	 * 
//	 * List retList =new ArrayList(); retList = jdbcTemplate.query(sqlQuery,new
//	 * Object[]{_assesseeNo,_caseNo},mutaCertMapper);
//	 * 
//	 * MUTACertDTO mutaCertDto = new MUTACertDTO();
//	 * 
//	 * System.out.println("******new**********assesseeRoDto="+retList.get(0));
//	 * 
//	 * mutaCertDto = (MUTACertDTO)retList.get(0);
//	 * 
//	 * List mainList = new ArrayList(); mainList.add(mutaCertDto);
//	 * 
//	 * System.out.println("************MUTA****IN ACTION="+mainList.size());
//	 * System.out.println("****************assesseeRoDto="+mutaCertDto.getAssesseeNo
//	 * ());
//	 * 
//	 * _portalServiceReturnObject.setObj(mainList); return
//	 * _portalServiceReturnObject;
//	 * 
//	 * }
//	 */
//
//	public KMCPortalServiceReturnObject getMUTAcertPrint(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//
//		StringBuffer _sbQuery1 = new StringBuffer(
//				"select A.asmt_assno, nvl(to_char(B.ASMT_APPROVE_DATE,'DD/MM/YYYY'),' ') APPROVEDATE, B.ASMT_N_PIN_CODE, B.ASMT_N_OWN_1 ||' '|| B.ASMT_N_OWN_2 ||' '|| ");
//		_sbQuery1.append(
//				" B.ASMT_N_OWN_3 ||' '|| B.ASMT_N_OWN_4 ||' '|| B.ASMT_N_OWN_5 ||' '|| B.ASMT_N_OWN_6 ||' '|| B.ASMT_N_OWN_7 ||' '|| B.ASMT_N_OWN_8 ||' '|| B.ASMT_N_OWN_9 ||' '|| B.ASMT_N_OWN_10 MUTAOWNER, B.asmt_case_no,  ");
//		_sbQuery1.append(
//				" B.ASMT_N_ADRS_1 ||' '||B.ASMT_N_ADRS_2 ||' '|| B.ASMT_N_ADRS_3 ||' '|| B.ASMT_N_ADRS_4 ||' '|| B.ASMT_N_ADRS_5 ||' '|| B.ASMT_N_ADRS_6 ||' '|| B.ASMT_N_ADRS_7 ||' '|| B.ASMT_N_ADRS_8 MUTAADDR , ");
//		_sbQuery1.append(
//				" a.asmt_registration_dtls, decode(nvl(asmt_flat_no,' '),' ',' ','Flat: '||asmt_flat_no) asmt_flat_no,a.asmt_prem_no||','||C.com_street_name prem_no, ");
//		_sbQuery1.append(
//				"  decode(a.asmt_nature_of_use,'',' ','Nature of Premise: '|| substr(a.asmt_nature_of_use,1,50)) asmt_nature_of_use ");
//		_sbQuery1.append(
//				" from asmt_muta_case_dtl B,asmt_asse_mst a,com_street_mst C,portal_pgw_txn_parent d,asmt_muta_app_txn e where   B.asmt_assno=? and B.asmt_case_no=? ");
//		_sbQuery1.append(
//				" and a.asmt_ward_no=C.com_ward_no and to_number(a.asmt_street_code)=to_number(C.com_street_code) AND A.asmt_assno =B.asmt_assno   ");
//		_sbQuery1.append(
//				" and B.asmt_assno=e.asmt_assno and e.txn_id=d.txn_id  and d.txn_status='S' and B.asmt_status='APPROVED' ");
//
//		String sqlQuery = _sbQuery1.toString();
//
//		System.out.println("sql query=" + sqlQuery);
//
//		MUTACertMapper mutaCertMapper = new MUTACertMapper();
//
//		List retList = new ArrayList();
//		try {
//			retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _caseNo }, mutaCertMapper);
//
//			MUTACertDTO mutaCertDto = new MUTACertDTO();
//
//			mutaCertDto = retList.size() > 0 ? (MUTACertDTO) retList.get(0) : null;
//
//			List mainList = new ArrayList();
//			mainList.add(mutaCertDto);
//			if (mutaCertDto != null) {
//				// System.out.println("******new**********assesseeRoDto="+retList.get(0));
//				String Q = "INSERT INTO MUTA_CERT_ISSUE  (ASMT_ASSNO,ASMT_CASE_NO,GEN_DATE) VALUES ('" + _assesseeNo
//						+ "','" + _caseNo + "',SYSDATE)";
//
//				System.out.println("************Q****IN ACTION=" + Q);
//				jdbcTemplate.execute(Q);
//			}
//			System.out.println("************MUTA****IN ACTION=" + mainList.size());
//			// System.out.println("****************assesseeRoDto="+mutaCertDto.getAssesseeNo());
//
//			_portalServiceReturnObject.setObj(mainList);
//			return _portalServiceReturnObject;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//
//		}
//
//	}
//
//	public HashMap getHistoryDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap impMap = new HashMap();
//		try {
//
//			String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//			String sqlReqDetails = KMCAssessmentConstants.getARAssesseeHistoryDetails();
//
//			System.out.println("***********getARAssesseeHistoryDetails=" + sqlReqDetails);
//
//			ArHistoryMapper arHistoryMapper = new ArHistoryMapper();
//			// ArHistoryMapper arHistoryMapper = new ArHistoryMapper();
//
//			List historyList = new ArrayList();
//
//			historyList = jdbcTemplate.query(sqlReqDetails, new Object[] { _assesseeNo, _assesseeNo, _assesseeNo,
//					_assesseeNo, _assesseeNo, _assesseeNo, _assesseeNo, _assesseeNo, _assesseeNo, _assesseeNo },
//					arHistoryMapper);
//
//			System.out.println("historyList.size() of getHistoryDetails::::::::::::::::" + historyList.size());
//			/*
//			 * _advertisementReceipt = (AdvertisementReceipt)tempList.get(0);
//			 * 
//			 * impMap.put(AdvertisementConstants.PrintAppConstants.ADV_CHILD_RECEIPT,
//			 * _advertisementReceipt);
//			 * 
//			 * String sqlChargeHeadDetails =
//			 * AdvertisementConstants.GET_CHARGE_HEAD_DETAILS();
//			 * 
//			 * List chargeHeadList = new ArrayList(); ArHistoryMapper arHistoryMapper = new
//			 * ArHistoryMapper();
//			 * 
//			 * chargeHeadList = jdbcTemplate.query(sqlChargeHeadDetails,new
//			 * Object[]{demandSerialNo,finYear},arHistoryMapper);
//			 */
//			impMap.put("HISTORY_LIST", historyList);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return impMap;
//	}
//
//	public HashMap getLandDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap impMap = new HashMap();
//		try {
//
//			String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//			String sqlReqDetails = KMCAssessmentConstants.getARLandAreaDetails();
//
//			System.out.println("***********getARAssesseeHistoryDetails=" + sqlReqDetails);
//
//			ArLandMapper arLandMapper = new ArLandMapper();
//			// ArHistoryMapper arHistoryMapper = new ArHistoryMapper();
//
//			List landList = new ArrayList();
//
//			landList = jdbcTemplate.query(sqlReqDetails, new Object[] { _assesseeNo }, arLandMapper);
//
//			System.out.println("landList.size() of getLandDetails::::::::::::::::" + landList.size());
//
//			impMap.put("LAND_LIST", landList);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return impMap;
//	}
//
//	public HashMap getArAddressDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap impMap = new HashMap();
//		try {
//
//			String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//			String sqlReqDetails = KMCAssessmentConstants.getARAddressDetails();
//
//			System.out.println("***********getAddressDetails=" + sqlReqDetails);
//
//			ArNameAddressMapper arNameAddressMapper = new ArNameAddressMapper();
//			// ArHistoryMapper arHistoryMapper = new ArHistoryMapper();
//
//			List addressList = new ArrayList();
//
//			addressList = jdbcTemplate.query(sqlReqDetails, new Object[] { _assesseeNo, _assesseeNo },
//					arNameAddressMapper);
//
//			System.out.println("addressList.size() of getAddressDetails::::::::::::::::" + addressList.size());
//
//			impMap.put("ADDRESS_LIST", addressList);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return impMap;
//	}
//
//	public HashMap getEffectiveQtrDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap impMap = new HashMap();
//		try {
//
//			String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//			String sqlReqDetails = KMCAssessmentConstants.getARQuterDetails();
//
//			System.out.println("***********getEffectiveQtrDetails=" + sqlReqDetails);
//
//			ArEffectiveQtrMapper arEffectiveQtrMapper = new ArEffectiveQtrMapper();
//			// ArHistoryMapper arHistoryMapper = new ArHistoryMapper();
//
//			List effectiveQtrList = new ArrayList();
//
//			effectiveQtrList = jdbcTemplate.query(sqlReqDetails, new Object[] { _assesseeNo, _assesseeNo, _assesseeNo },
//					arEffectiveQtrMapper);
//
//			System.out.println(
//					"effectiveQtrList.size() of getEffectiveQtrDetails::::::::::::::::" + effectiveQtrList.size());
//
//			impMap.put("QTR_LIST", effectiveQtrList);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return impMap;
//	}
//
//	public HashMap getHeritageDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap impMap = new HashMap();
//		try {
//
//			String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//			String sqlReqDetails = KMCAssessmentConstants.getARHeritageDetails();
//
//			System.out.println("***********getHeritageDetails=" + sqlReqDetails);
//
//			ArHeritageMapper arHeritageMapper = new ArHeritageMapper();
//			// ArHistoryMapper arHistoryMapper = new ArHistoryMapper();
//
//			List heritageList = new ArrayList();
//
//			heritageList = jdbcTemplate.query(sqlReqDetails, new Object[] { _assesseeNo }, arHeritageMapper);
//
//			System.out.println("heritageList.size() of getHeritageDetails::::::::::::::::" + heritageList.size());
//
//			impMap.put("HERITAGE_LIST", heritageList);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return impMap;
//	}
//
//	private static final class AssesseeInfoMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			PDDemand _pdDemand = new PDDemand();
//			_pdDemand.setMailingAddressLine1(rs.getString("ASMT_ADRS_1"));
//			_pdDemand.setMailingAddressLine2(rs.getString("ASMT_ADRS_2"));
//			_pdDemand.setMailingAddressLine3(rs.getString("ASMT_ADRS_3"));
//			// System.out.println("Addrd 3::::"+_pdDemand.getMailingAddressLine3());
//			_pdDemand.setMailingAddressLine4(rs.getString("ASMT_ADRS_4"));
//			_pdDemand.setMailingAddressLine5(rs.getString("ASMT_ADRS_5"));
//			_pdDemand.setMailingAddressLine6(rs.getString("ASMT_ADRS_6"));
//			_pdDemand.setMailingAddressLine7(rs.getString("ASMT_ADRS_7"));
//			_pdDemand.setMailingAddressLine8(rs.getString("ASMT_ADRS_8"));
//			_pdDemand.setPersonLiable(rs.getString("PERSON_LIABLE"));
//			_pdDemand.setMailingPinCode(rs.getString("ASMT_PIN_CODE"));
//			_pdDemand.setWardNo(rs.getString("ASMT_WARD_NO"));
//			_pdDemand.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			_pdDemand.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			_pdDemand.setStreetName(rs.getString("COM_STREET_NAME"));
//			_pdDemand.setOwnerName1(rs.getString("OWNER"));
//			_pdDemand.setOwnerName2(rs.getString("ASMT_OWN_2"));
//			_pdDemand.setOwnerName3(rs.getString("ASMT_OWN_3"));
//			_pdDemand.setOwnerName4(rs.getString("ASMT_OWN_4"));
//			_pdDemand.setOwnerName5(rs.getString("ASMT_OWN_5"));
//			_pdDemand.setOwnerName6(rs.getString("ASMT_OWN_6"));
//			_pdDemand.setOwnerName7(rs.getString("ASMT_OWN_7"));
//			_pdDemand.setOwnerName8(rs.getString("ASMT_OWN_8"));
//			_pdDemand.setOwnerName9(rs.getString("ASMT_OWN_9"));
//			_pdDemand.setOwnerName10(rs.getString("ASMT_OWN_10"));
//
//			return _pdDemand;
//		}
//	}
//
//	////// ****** GET ASSESSEE INFORMATION ***********************////////////
//
//	public KMCPortalServiceReturnObject getAssesseeInfo(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		String sqlQuery = KMCAssessmentConstants.GET_ASSESSEE_INFO();
//		// System.out.println("sqlQuery:::::::::::::::::::::::::::::::"+sqlQuery);
//		AssesseeInfoMapper _assesseeInfoMapper = new AssesseeInfoMapper();
//		PDDemand _pdDemand = new PDDemand();
//		_pdDemand = (PDDemand) jdbcTemplate.queryForObject(sqlQuery, new Object[] { _assesseeNo, wardNo },
//				_assesseeInfoMapper);
//
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.PrintAppConstants.PD_DEMAND, _pdDemand);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//
//		return _portalServiceReturnObject;
//	}
//
//	//////////////////////////////////////////////////////////////
//	private static final class DuplicatePDBarcodeMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			PDBarcodeDetails _pdBarcodeDetails = new PDBarcodeDetails();
//			_pdBarcodeDetails.setQuarterNo(rs.getString("BILLED_QTR"));
//			_pdBarcodeDetails.setPdBarcode(rs.getString("DUPLICATE_PD_BARCODE"));
//			return _pdBarcodeDetails;
//		}
//	}
//
//	///////////////// Getting Barcode Details ///////////////////////////////////
//	public HashMap getBarcodeDetailsForPDPrint(HashMap infoMap) throws KMCPortalBusinessException {
//		// KMCPortalServiceReturnObject _portalServiceReturnObject = new
//		// KMCPortalServiceReturnObject();
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		System.out.println("_assesseeNo:::::::::" + _assesseeNo);
//		System.out.println("wardNo:::::::::::" + wardNo);
//		String billedYear = null;
//
//		billedYear = KMCAssessmentUtility.getCurrentFinYear();
//		billedYear = billedYear.substring(0, 4);
//		System.out.println("billedYear::::::::::::::::::::::::" + billedYear);
//		// String sqlQuery =
//		// KMCAssessmentConstants.GET_DUPLICATE_PD_BARCODE_DTLS();//commented on 29-3-12
//		// to change pd barcode
//		String sqlQuery = KMCAssessmentConstants.GET_DUPLICATE_PD_BARCODE_DTLS1(); // added on 29-3-12 to change pd
//																					// barcode
//		// System.out.println("sqlQuery::::::::::::::"+sqlQuery);
//		DuplicatePDBarcodeMapper _duplicatePDBarcodeMapper = new DuplicatePDBarcodeMapper();
//		List pdBarcodeList = new ArrayList();
//		pdBarcodeList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo, billedYear },
//				_duplicatePDBarcodeMapper);
//
//		returnMap.put("pdBarcodeList", pdBarcodeList);
//
//		return returnMap;
//	}
//
//	/**
//	 * Mutation RowMapper
//	 * 
//	 * @256197
//	 */
//
//	private static final class MutationMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			MutationStatusDTO _mutationDTO = (MutationStatusDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.MutationStatusDTO");
//			_mutationDTO.setCaseNo(rs.getString("CASE_NO"));
//			_mutationDTO.setReceiptDate(rs.getString("DATE_OF_RECEIPT"));
//			_mutationDTO.setAppilicantName(rs.getString("APPLICANT_NAME"));
//			_mutationDTO.setStatus(rs.getString("STATUS"));
//			_mutationDTO.setLawRemarks(rs.getString("LAW_REMARKS"));
//			_mutationDTO.setAsmtRemarks(rs.getString("Asmt_Remarks"));
//			return _mutationDTO;
//		}
//	}
//
//	public KMCPortalServiceReturnObject getMutationStatus(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getMutationStatus of mutation DAO");
//		}
//
//		String asseno = (String) infoMap.get("ASSESSENO");
//		String caseno = (String) infoMap.get("CASENO");
//		// System.out.println("ASSESSEE NO::::::::"+asseno);
//
//		String sql = KMCAssessmentConstants.getMutationStatus();
//		// String ModifiedSql = sql + "MINUS"+sql;
//
//		// System.out.println("sql::::::::::::"+sql);
//		// System.out.println(sql);
//
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { asseno, caseno }, new MutationMapper());
//		sql = null;// ModifiedSql=null;
//
//		if (arrayList == null || arrayList.size() == 0) {
//
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Records do not exist for the given Search ");
//			throw _busException;
//		}
//
//		int iTemp = arrayList.size();
//		List arrayListFinal = new ArrayList();
//
//		if (iTemp > 0) {
//			for (int i = 0; i < iTemp; i++) {
//				MutationStatusDTO mutationDTO = (MutationStatusDTO) arrayList.get(i);
//				String sTemp = mutationDTO.getCaseNo();
//
//				String sql1 = KMCAssessmentConstants.getDoc();
//				List arrayList1 = new ArrayList();
//				arrayList1 = jdbcTemplate.query(sql1, new Object[] { sTemp }, new DocMapper());
//				sql1 = null;// ModifiedSql=null;
//
//				int iTempSize = arrayList1.size();
//				StringBuffer sbTemp = new StringBuffer("");
//				if (iTempSize > 0) {
//					for (int j = 0; j < iTempSize; j++) {
//						MutationDocDTO mutationdocDTO = (MutationDocDTO) arrayList1.get(j);
//						sbTemp.append(mutationdocDTO.getDocName() + "   ");
//					}
//				}
//				mutationDTO.setDocName(sbTemp.toString());
//				arrayListFinal.add(mutationDTO);
//			}
//		}
//
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.HEARINGLIST, arrayListFinal);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getMutationStatus of Mutation DAO");
//		}
//		return _obj;
//	}
//
//	private static final class DocMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			MutationDocDTO _mutationdocDTO = (MutationDocDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.MutationDocDTO");
//
//			_mutationdocDTO.setDocName(rs.getString("NAME_OF_DOCUMENT_REQUIRED"));
//			return _mutationdocDTO;
//		}
//	}
//
//	public KMCPortalServiceReturnObject getDoc(HashMap infoMap) {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getDoc of mutation DAO");
//		}
//
//		String caseCode = (String) infoMap.get("passedcaseCode");
//		System.out.println("Case Code::::::::" + caseCode);
//
//		String sql = KMCAssessmentConstants.getDoc();
//		// String ModifiedSql = sql + "MINUS"+sql;
//
//		// System.out.println("sql::::::::::::"+sql);
//		// System.out.println(sql);
//
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { caseCode }, new DocMapper());
//		sql = null;// ModifiedSql=null;
//
//		// System.out.println(":::::::::::::::::::::"+arrayList);
//
//		// System.out.println(arrayList);
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.DEMANDLISTFS, arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getDoc of Mutation DAO");
//		}
//		return _obj;
//	}
//
//	private static final class PDReceipTxnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			PDReceipt _pdReceipt = new PDReceipt();
//			_pdReceipt.setTotalAmt(rs.getString("TXN_AMOUNT"));
//			_pdReceipt.setReceiptDate(rs.getString("RECEIPT_DATE"));
//			_pdReceipt.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			_pdReceipt.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			_pdReceipt.setAmtInWords(rs.getString("AMT_IN_WORDS"));
//			_pdReceipt.setPaymodeShortDesc(rs.getString("PAY_MODE_SHORT_DESC"));
//			_pdReceipt.setPaymodeDesc(rs.getString("PAY_MODE_DESC"));
//			return _pdReceipt;
//		}
//	}
//
//	public HashMap getReceiptTxnDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap passedMap = new HashMap();
//		String transactionID = (String) infoMap.get("TXN_ID");
//		String sqlQuery = KMCAssessmentConstants.GET_TXN_DETAILS();
//		// System.out.println(sqlQuery);
//		PDReceipTxnMapper _pdReceipTxnMapper = new PDReceipTxnMapper();
//		PDReceipt _pdReceipt = (PDReceipt) jdbcTemplatePay.queryForObject(sqlQuery, new Object[] { transactionID },
//				_pdReceipTxnMapper);
//		_pdReceipt.setTxnId(transactionID);
//		passedMap.put(KMCAssessmentConstants.PrintAppConstants.PD_RECEIPT, _pdReceipt);
//		return passedMap;
//
//	}
//
//	private static final class PDReceiptBillMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			PDReceiptBillDetails _pdReceiptBillDetails = new PDReceiptBillDetails();
//			_pdReceiptBillDetails.setBillType(rs.getString("ASMT_BILL_TYPE"));
//			_pdReceiptBillDetails.setQuarterNo(rs.getString("ASMT_BILLED_QTR"));
//			_pdReceiptBillDetails.setGrossAmt(rs.getString("ASMT_PAYABLE_AMT"));
//			_pdReceiptBillDetails.setRebateAmt(rs.getString("ASMT_REBATE_AMT"));
//			_pdReceiptBillDetails.setPenaltyAmt(rs.getString("ASMT_PENALTY_AMT"));
//			_pdReceiptBillDetails.setInterestAmt(rs.getString("ASMT_INTEREST_AMT"));
//			_pdReceiptBillDetails.setNetAmt(rs.getString("ASMT_NET_AMT"));
//
//			return _pdReceiptBillDetails;
//		}
//	}
//
//	public HashMap getReceiptBillDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String receiptNo = (String) infoMap.get("PD_RECEIPTNO");
//
//		// String receiptNo = "E2" ;
//
//		String sqlQuery = KMCAssessmentConstants.GET_RECEIPT_BILL_DETAILS();
//		// System.out.println("sqlQuery::::::::::::::"+sqlQuery);
//		PDReceiptBillMapper _pdReceiptBillMapper = new PDReceiptBillMapper();
//		List receiptBillList = new ArrayList();
//		receiptBillList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _assesseeNo, receiptNo },
//				_pdReceiptBillMapper);
//
//		returnMap.put("receiptBillList", receiptBillList);
//
//		return returnMap;
//
//	}
//
//	// ADDED BY SOUGATA ON 01.03.2010
//	public KMCPortalServiceReturnObject getAssDetailsForDisplay(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getDoc of getAssDetailsForDisplay");
//		}
//		String assessNo = (String) infoMap.get("ASSESS_NO");
//		List arrayList = new ArrayList();
//		String sql = KMCAssessmentConstants.getASSDETAILTODISPLAY();
//		arrayList = jdbcTemplate.query(sql, new Object[] { assessNo }, new AssesseeRowMapper());
//		sql = null;// ModifiedSql=null;
//		HashMap returnMap = new HashMap();
//		returnMap.put("ASS_DTL", arrayList);
//		_obj.setReturnMap(returnMap);
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving into getDoc of getAssDetailsForDisplay");
//		}
//
//		return _obj;
//
//	}
//
//	public HashMap getREVTxnDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getREVTxnDetails of AssessmentDAO for REVENUE Receipt Details");
//		}
//		String TxnId = (String) infoMap.get("TXN_ID");
//		List arrayList = new ArrayList();
//		String eParam = (String) infoMap.get("E_PARAM");
//
//		RevReceiptDetRowMapper _revReceiptDetRowMapper = new RevReceiptDetRowMapper();
//		// String getAssesseNoFromTxnIdSQL =
//		// KMCAssessmentConstants.getAssesseNoFromTxnId();
//		RevenuePrintObject _revRevenuePrintObject = new RevenuePrintObject();
//		String txnSql = "";
//
//		if ("printReceipt".equals(eParam)) {
//			txnSql = KMCAssessmentConstants.getREV_RECEIPT_DETAILS_TXN();
//
//			_revRevenuePrintObject = (RevenuePrintObject) jdbcTemplatePay.queryForObject(txnSql, new Object[] { TxnId },
//					_revReceiptDetRowMapper);
//		}
//
//		else if ("rePrintReceipt".equals(eParam)) {
//
//			String eReceiptNo = (String) infoMap.get("RECEIPT_NO");
//			String txnId = (String) infoMap.get("TXN_ID");
//
//			txnSql = KMCAssessmentConstants.GET_REV_RECEIPT_DETAILS_TXN_REPRINT();
//			_revRevenuePrintObject = (RevenuePrintObject) jdbcTemplateRevenue.queryForObject(txnSql,
//					new Object[] { eReceiptNo, txnId }, _revReceiptDetRowMapper);
//		}
//
//		txnSql = null;// ModifiedSql=null;
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("REV_RECEIPT_PRINT", _revRevenuePrintObject);
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getREVTxnDetails of AssessmentDAO for REVENUE Receipt Details");
//		}
//
//		return returnMap;
//
//	}
//
//	public HashMap getREVDetailsFromASMT(HashMap infoMap) throws KMCPortalBusinessException {
//
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getREVDetailsFromASMT of AssessmentDAO for REVENUE Receipt Details");
//		}
//		String AssesNo = (String) infoMap.get("ASSESSEE_NUM");
//
//		String txnSql = KMCAssessmentConstants.getREV_RECEIPT_DETAILS_FROM_ASMT();
//		RevenuePrintObject _revRevenuePrintObject = new RevenuePrintObject();
//
//		_revRevenuePrintObject = (RevenuePrintObject) jdbcTemplate.queryForObject(txnSql, new Object[] { AssesNo },
//				new RevASMTReceiptDetRowMapper());
//
//		txnSql = null;// ModifiedSql=null;
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("REV_RECEIPT_PRINT_FROM_ASMT", _revRevenuePrintObject);
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getREVDetailsFromASMT of AssessmentDAO for REVENUE Receipt Details");
//		}
//
//		return returnMap;
//
//	}
//
//	// END OF ADDED ON 01.03.2010
//
//	private static final class PDReceiptBarcodeMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			PDReceiptBarcodeDetails _pdReceiptBarcodeDetails = new PDReceiptBarcodeDetails();
//			_pdReceiptBarcodeDetails.setPdReceiptBarcode(rs.getString("RCPT_BARCODE"));
//			return _pdReceiptBarcodeDetails;
//		}
//	}
//
//	/// Start of Code by Debarshi as on 02/03/2010 /////////////////////
//
//	public HashMap getReceiptBarcodeDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		String transactionID = (String) infoMap.get("TXN_ID");
//		PDReceiptBarcodeDetails pdRcptBarcode = null;
//		String sql = KMCAssessmentConstants.GET_RECEIPT_BARCODE_DETAILS();
//		pdRcptBarcode = (PDReceiptBarcodeDetails) jdbcTemplatePay.queryForObject(sql, new Object[] { transactionID },
//				new PDReceiptBarcodeMapper());
//		sql = null;// ModifiedSql=null;
//		HashMap returnMap = new HashMap();
//		returnMap.put("RCPT_BARCODE", pdRcptBarcode);
//
//		return returnMap;
//
//	}
//	////////////// End Of Code by Debarshi //////////////////////////
//
//	//// Added by Debarshi Majumder as on 04/03/2010 for PD Receipt ////////////
//
//	private static final class DuplicateReceiptMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AsmtPDReceiptDTO asmtReceiptDTO = (AsmtPDReceiptDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.AsmtPDReceiptDTO");
//
//			asmtReceiptDTO.setTxnID(rs.getString("TXN_ID"));
//			asmtReceiptDTO.setTxnType(rs.getString("TXN_TYPE"));
//			asmtReceiptDTO.setTxnAmount(rs.getString("TXN_AMOUNT"));
//			asmtReceiptDTO.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			asmtReceiptDTO.setReceiptDate(rs.getString("RECEIPT_DATE"));
//			asmtReceiptDTO.setTxnPayModeDesc(rs.getString("PAY_MODE_DESC"));
//			asmtReceiptDTO.setTxnPayModeShortDesc(rs.getString("PAY_MODE_SHORT_DESC"));
//			return asmtReceiptDTO;
//
//		}// end of method
//
//	}
//
//	private static final class ReceiptMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			ReceiptDTO _receiptDTO = (ReceiptDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.ReceiptDTO");
//			_receiptDTO.setReceiptNo(rs.getString("ASMT_RECEIPT_NO"));
//			return _receiptDTO;
//
//		}// end of method
//
//	}
//
//	public KMCPortalServiceReturnObject searchDetailsForPDReceipt(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getDoc of searchDetailsForPDReceipt");
//		}
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String fromDate = (String) infoMap.get("FROM_DATE");
//		String toDate = (String) infoMap.get("TO_DATE");
//		System.out.println("toDate::::::::::::" + toDate);
//
//		List txnDetailList = new ArrayList();
//		String sql = KMCAssessmentConstants.DUPLICATE_RECEIPT_DETAILS();
//
//		String getReceiptNoSQL = KMCAssessmentConstants.GET_RCPT_NO_WITH_ASSNO();
//		// System.out.println(getReceiptNoSQL);
//		List receiptList = jdbcTemplate.query(getReceiptNoSQL,
//				new Object[] { assesseeNo, assesseeNo, fromDate, toDate }, new ReceiptMapper());
//		HashMap returnMap = new HashMap();
//		ReceiptDTO _receiptDTO = null;
//		ArrayList rcptList = new ArrayList();
//
//		for (int i = 0; i < receiptList.size(); i++) {
//			_receiptDTO = (ReceiptDTO) receiptList.get(i);
//			///// TAKING FROM PORTAL_PAY Schema (jdbcTemplatePay)
//			///// ////////////////////////////////
//			txnDetailList = jdbcTemplatePay.query(sql, new Object[] { fromDate, toDate, _receiptDTO.getReceiptNo() },
//					new DuplicateReceiptMapper());
//			rcptList.addAll(txnDetailList);
//
//		}
//		// System.out.println("rcptList"+rcptList.size());
//		returnMap.put("TXN_DTLS", rcptList);
//		sql = null;// ModifiedSql=null;
//
//		_obj.setReturnMap(returnMap);
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving into getDoc of searchDetailsForPDReceipt");
//		}
//
//		return _obj;
//
//	}
//
//	//////////////// End of Code by Debarshi /////////////////////////////////
//
//	public KMCPortalServiceReturnObject getPaymentStatus(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getDoc of mutation DAO");
//		}
//
//		String caseCode = (String) infoMap.get("ASSESSENO");
//		String mama = "arnab";
//
//		String wardNo = caseCode.substring(2, 5);
//		String validAssesseeSql = KMCAssessmentConstants.CHECK_IF_VALID_ASSESSEE();
//		List assesseeValidList = new ArrayList();
//		assesseeValidList = jdbcTemplate.query(validAssesseeSql, new Object[] { caseCode }, new AssesseeValidMapper());
//
//		if (assesseeValidList == null || assesseeValidList.size() == 0) {
//
//			mama = "Invalid Assessee No";
//
//		}
//
//		StringBuffer sqlBuff = KMCAssessmentConstants.GETPAYMENTSTATUS();
//		sqlBuff.append(" AND T.ASMT_WARD_NO = '" + wardNo + "' ");
//		sqlBuff.append(" ORDER BY T.ASMT_BILLED_QTR, T.ASMT_BILL_TYPE, T.ASMT_SHARE_TYPE, T.ASMT_REBATE_DATE ");
//
//		String sql = sqlBuff.toString();
//
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { caseCode }, new PaymentStatusMapper());
//		sql = null;// ModifiedSql=null;
//
//		// System.out.println(":::::::::::::::::::::"+arrayList);
//		if (arrayList == null || arrayList.size() == 0) {
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("Records do not exist for the given Assessee Number ");
//			mama = "Records do not exist for the given Assessee Number";
//			// throw _portException;
//
//		}
//
//		// System.out.println(arrayList);
//		HashMap returnMap = new HashMap();
//
//		System.out.println("MAMA::::::" + mama);
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.DEMANDLISTFS, arrayList);
//		returnMap.put("Error_String", mama);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getDoc of Mutation DAO");
//		}
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject getPayeeDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getPayeeDetails of Assessment DAO");
//		}
//
//		String caseCode = (String) infoMap.get("ASSESSENO");
//
//		List retListAssCheck = new ArrayList();
//		String sTempAssCheck = " select t.asmt_status from asmt_asse_mst t where t.asmt_assno = ? ";
//		retListAssCheck = jdbcTemplate.query(sTempAssCheck, new Object[] { caseCode }, new AssCheckRowmapper());
//		if (retListAssCheck.size() > 0) {
//			DemandCollectionDTO demandCollectionDTO = (DemandCollectionDTO) retListAssCheck.get(0);
//			String sTempAssStatus = demandCollectionDTO.getAssStatus();
//
//			if (sTempAssStatus.equalsIgnoreCase("X")) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("This assessee is blocked");
//				throw _busException;
//			}
//		}
//
//		String sql = KMCAssessmentConstants.GETPAYEEDETAILS();
//
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { caseCode }, new PayeeDetailsMapper());
//		sql = null;// ModifiedSql=null;
//
//		// System.out.println(":::::::::::::::::::::"+arrayList);
//		if (arrayList == null || arrayList.size() == 0) {
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("Records do not exist for the given Assessee Number ");
//			throw _portException;
//
//		}
//
//		// System.out.println(arrayList);
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.PAYEEDETAILS, arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getPayeeDetails of Assessment DAO");
//		}
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject getSuspenseBalance(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getSuspenseBalance of Assessment DAO");
//		}
//
//		String caseCode = (String) infoMap.get("ASSESSENO");
//		String mama = "arnab";
//
//		String wardNo = caseCode.substring(2, 5);
//
//		StringBuffer sqlBuff = KMCAssessmentConstants.GETSUSPENSEBALANCE();
//		sqlBuff.append(" AND A.ASMT_WARD_NO = '" + wardNo + "' ");
//		sqlBuff.append(" AND A.ASMT_STATUS = 'A' ");
//
//		String sql = sqlBuff.toString();
//
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { caseCode }, new SuspenseBalanceMapper());
//		sql = null;// ModifiedSql=null;
//
//		// System.out.println(":::::::::::::::::::::"+arrayList);
//		if (arrayList == null || arrayList.size() == 0) {
//
//			mama = "Suspense Records do not exists for the given Assessee";
//
//		}
//
//		// System.out.println(arrayList);
//		HashMap returnMap = new HashMap();
//		returnMap.put("SUSPENSEBALANCE", arrayList);
//		returnMap.put("Error_String", mama);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getSuspenseBalance of Assessment DAO");
//		}
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject getNOCDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getSuspenseBalance of Assessment DAO");
//		}
//
//		// try{
//		String caseCode = (String) infoMap.get("ASSESSENO");
//
//		String checkInstanceSql = "SELECT T.ASMT_ASSNO ASSESSEE_NO FROM ASMT_NOC T WHERE T.ASMT_ASSNO = ? ";
//		List checkInstanceList = new ArrayList();
//
//		checkInstanceList = jdbcTemplate.query(checkInstanceSql, new Object[] { caseCode }, new CheckInstanceMapper());
//
////        if(checkInstanceList!=null && checkInstanceList.size()!=0)
////        {
////           KMCPortalBusinessException _portException = new KMCPortalBusinessException();
////              _portException.setErrMesg("APPLICATION FOR THE ENTERED ASSESSEE NO HAS ALREADY BEEN RECEIVED ");
////              throw _portException;
////            
////        }
//
//		String wardNo = caseCode.substring(2, 5);
//		System.out.println(wardNo);
//		String validAssesseeSql = KMCAssessmentConstants.CHECK_IF_VALID_ASSESSEE();
//		List assesseeValidList = new ArrayList();
//		assesseeValidList = jdbcTemplate.query(validAssesseeSql, new Object[] { caseCode }, new AssesseeValidMapper());
//
//		if (assesseeValidList == null || assesseeValidList.size() == 0) {
//			System.out.println("inside the exception block");
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("Sorry Invalid Assessee No");
//			throw _portException;
//
//		}
//
//		String assDemandValidSql = KMCAssessmentConstants.CHECK_IF_DEMAD_EXIST_FOR_ASSESSEE();
//		System.out.println(":::::::::::::::::::::::::::::::::::::::::");
//		System.out.println(assDemandValidSql);
//		int assessDemandInt = jdbcTemplate.queryForInt(assDemandValidSql, new Object[] { caseCode });
//
//		System.out.println("assesseeDemandList:::::::::" + assessDemandInt);
//		////
//		if (assessDemandInt != 0) {
//
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("Please pay the outstanding taxes before applying for NOC ");
//			throw _portException;
//
//		}
//
//		String getOfficeCode = "SELECT T.COM_OFFICE_CD OFFICE_CODE FROM COM_MODULE_OFFICE_WARD_MAP T WHERE T.COM_WARD_NO = ? ";
//
//		System.out.println(getOfficeCode);
//
//		String officeCode = new String();
//		officeCode = (String) this.jdbcTemplate.queryForObject(getOfficeCode, new Object[] { wardNo }, String.class);
//
//		if (officeCode == null || officeCode.length() == 0) {
//
//			KMCPortalBusinessException _portException = new KMCPortalBusinessException();
//			_portException.setErrMesg("System is Busy!Please Try Later! ");
//			throw _portException;
//
//		}
//
//		String findSeq = "SELECT T.ASMT_SEQ_NAME SEQ FROM ASMT_SEQUENCE_TABLE T WHERE T.ASMT_SEQ_NAME = 'ASMT_E_NOC_SEQ' ";
//		List findSeqList = new ArrayList();
//
//		findSeqList = jdbcTemplate.query(findSeq, new Object[] {}, new FindSeqMapper());
//
//		if (findSeqList == null || findSeqList.size() == 0) {
//
//			String insertSeq = "INSERT INTO ASMT_SEQUENCE_TABLE T (T.ASMT_SEQ_NAME, T.ASMT_SEQ_NO, T.ASMT_OFFICE_CD)VALUES ('ASMT_E_NOC_SEQ', '1', '')  ";
//			jdbcTemplate.execute(insertSeq);
//
//		}
//
//		String getSeq = "SELECT T.ASMT_SEQ_NO FROM ASMT_SEQUENCE_TABLE T WHERE T.ASMT_SEQ_NAME='ASMT_E_NOC_SEQ' ";
//		String seqNo = (String) jdbcTemplate.queryForObject(getSeq, new Object[] {}, String.class);
//
//		String mainSQL = "INSERT INTO ASMT_NOC T (T.ASMT_ASSNO,T.ASMT_NOC_APPLN_NO,T.ASMT_NOC_APPLN_DATE,T.ASMT_NOC_APPLN_STATUS,T.VER_NO,T.ASMT_OFFICE_CD,T.CREATE_UID,T.CREATE_DATE,T.ASMT_WARD_NO,T.ASMT_NO_OF_ENCLOSURES,T.ASMT_PORTAL_YN) VALUES ('"
//				+ caseCode + "','P" + seqNo + "',TO_DATE(SYSDATE),'N','1','" + officeCode + "','1',TO_DATE(SYSDATE),'"
//				+ wardNo + "','0','Y')";
//		System.out.println(mainSQL);
//		jdbcTemplate.execute(mainSQL);
//		String updateQuery = "UPDATE ASMT_SEQUENCE_TABLE A SET A.ASMT_SEQ_NO = A.ASMT_SEQ_NO + 1  WHERE A.ASMT_SEQ_NAME = 'ASMT_E_NOC_SEQ' ";
//		jdbcTemplate.execute(updateQuery);
//
//		// System.out.println(arrayList);
//		HashMap returnMap = new HashMap();
//		returnMap.put("APPLICATION_NO", "P" + seqNo);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
////        }
////        catch(Exception ex)
////        {
////          ex.printStackTrace();
////        }
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getSuspenseBalance of Assessment DAO");
//		}
//		return _obj;
//	}
//
/////////////////////Miyenka///////////////////////////////////////
//
//	public KMCPortalServiceReturnObject getNOCStatusDetails(HashMap infoMap) {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getNOCStatusDetails of Assessment DAO");
//		}
//
//		String _assesseeNo = (String) infoMap.get("ASSESSEE_NO");
//		System.out.println("Assessee No:::::" + _assesseeNo);
//
//		String sql = KMCAssessmentConstants.QUERY_NOC_STATUS_DETAILS();
//
//		// sql = sql+ " WHERE T.ADVT_PARTY_NAME LIKE UPPER(?) ORDER BY
//		// T.ADVT_PARTY_CODE";
//		// String ModifiedSql = sql + "MINUS"+sql;
//
//		// System.out.println("sql::::::::::::"+sql);
//
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { _assesseeNo }, new NOCStatusMapper());
//		sql = null;// ModifiedSql=null;
//
//		// int noOfRows =
//		// jdbcTemplate.queryForInt(KMCBuildingConstants.getNoOfArchitect());
//		HashMap returnMap = new HashMap();
//		// returnMap.put(KMCPortalServiceConstants.ServiceDefinationClass.NOOFROWS,String.valueOf(noOfRows));
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.HEARINGLIST, arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving getNOCStatusDetails of Assessment DAO");
//		}
//		return _obj;
//	}
//
//	private static final class NOCStatusMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			NOCStatusDTO _nocstatusdto = (NOCStatusDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.NOCStatusDTO");
//
////             _advertisementagentdto.setAgentCode(rs.getString("ADVT_PARTY_CODE"));
////             _advertisementagentdto.setAgentName(rs.getString("ADVT_PARTY_NAME"));
////             _advertisementagentdto.setAgentAddress(rs.getString("ADDRESS"));
////             _advertisementagentdto.setAgentPhone(rs.getString("ADVT_PHONE"));
////             _advertisementagentdto.setAgentMobile(rs.getString("ADVT_MOBILE_PHONE"));
////             _advertisementagentdto.setAgentEmail(rs.getString("ADVT_EMAIL"));
////             return _advertisementagentdto;
//			_nocstatusdto.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			_nocstatusdto.setApplicationNo(rs.getString("APPLICATION_NO"));
//			_nocstatusdto.setApplicationDate(rs.getString("APPLICATION_DATE"));
//			_nocstatusdto.setApplicationStatus(rs.getString("APPLICATION_STATUS"));
//			_nocstatusdto.setValidUpto(rs.getString("NOC_VALID_UPTO_IF_ISSUED"));
//			return _nocstatusdto;
//
//		}
//	}
//
//	///////////////////////////////////////// Added By Debarshi Majumder
//	///////////////////////////////////////// //////////////////
//
//	private static final class FSReceipTxnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			FSReceipt _fsReceipt = new FSReceipt();
//			_fsReceipt.setTotalAmt(rs.getString("TXN_AMOUNT"));
//			_fsReceipt.setReceiptDate(rs.getString("RECEIPT_DATE"));
//			_fsReceipt.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			_fsReceipt.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			_fsReceipt.setAmtInWords(rs.getString("AMT_IN_WORDS"));
//			_fsReceipt.setPaymodeShortDesc(rs.getString("PAY_MODE_SHORT_DESC"));
//			_fsReceipt.setPaymodeDesc(rs.getString("PAY_MODE_DESC"));
//			return _fsReceipt;
//		}
//	}
//
//	// Added by Dipankar for Assess Status checking during online payment
//	private static final class AssesseeStatusRowMapper implements RowMapper {
//
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			KMCAssementAssessDtlDTO asmtDTO = (KMCAssementAssessDtlDTO) DTOFactory
//					.createDTO("com.kmc.mas.mtps.assessment.dto.KMCAssementAssessDtlDTO");
//			asmtDTO.setAssesseeStatus(rs.getString("ASMT_STATUS"));
//			return asmtDTO;
//
//		}// end of method
//
//	}
//
//	public HashMap getFSReceiptTxnDetails(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap passedMap = new HashMap();
//		String transactionID = (String) infoMap.get("TXN_ID");
//		String sqlQuery = KMCAssessmentConstants.GET_FS_TXN_DETAILS();
//		// System.out.println(sqlQuery);
//		FSReceipTxnMapper _fsReceipTxnMapper = new FSReceipTxnMapper();
//		FSReceipt _fsReceipt = (FSReceipt) jdbcTemplatePay.queryForObject(sqlQuery, new Object[] { transactionID },
//				_fsReceipTxnMapper);
//		_fsReceipt.setTxnId(transactionID);
//		passedMap.put(KMCAssessmentConstants.PrintAppConstants.FS_RECEIPT, _fsReceipt);
//		return passedMap;
//
//	}
//
//	private static final class FSReceiptBillMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			FSReceiptBillDetails _fsReceiptBillDetails = new FSReceiptBillDetails();
//			_fsReceiptBillDetails.setBillType(rs.getString("ASMT_BILL_TYPE"));
//			_fsReceiptBillDetails.setFromQuarterNo(rs.getString("FROM_QTR"));
//			_fsReceiptBillDetails.setToQuarterNo(rs.getString("TO_QTR"));
//			_fsReceiptBillDetails.setPayableAmt(rs.getString("PAYABLE_AMT"));
//			_fsReceiptBillDetails.setRebateAmt(rs.getString("REBATE_AMT"));
//			_fsReceiptBillDetails.setNetAmt(rs.getString("NET_AMT"));
//			_fsReceiptBillDetails.setShareType(rs.getString("ASMT_SHARE_TYPE"));
//
//			return _fsReceiptBillDetails;
//		}
//	}
//
//	public HashMap getFSReceiptBillDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String receiptNo = (String) infoMap.get("FS_RECEIPTNO");
//
//		String sqlQuery = KMCAssessmentConstants.GET_FS_RECEIPT_BILL_DETAILS();
//		// System.out.println("sqlQuery::::::::::::::"+sqlQuery);
//		FSReceiptBillMapper _fsReceiptBillMapper = new FSReceiptBillMapper();
//		List receiptBillList = new ArrayList();
//		receiptBillList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { receiptNo, _assesseeNo, _assesseeNo },
//				_fsReceiptBillMapper);
//		// System.out.println("receiptBillList.siz::::::::::::::"+receiptBillList.size());
//		returnMap.put("receiptBillList", receiptBillList);
//
//		return returnMap;
//
//	}
//
//	public void setDataSourcePay(DataSource dataSourcePay) {
//		this.dataSourcePay = dataSourcePay;
//		this.jdbcTemplatePay = new JdbcTemplate(dataSourcePay);
//	}
//
//	public DataSource getDataSourcePay() {
//		return dataSourcePay;
//	}
//
//	public void setJdbcTemplatePay(JdbcTemplate jdbcTemplatePay) {
//		this.jdbcTemplatePay = jdbcTemplatePay;
//	}
//
//	public JdbcTemplate getJdbcTemplatePay() {
//		return jdbcTemplatePay;
//	}
//
//	public void setDataSourceRevenue(DataSource dataSourceRevenue) {
//		this.dataSourceRevenue = dataSourceRevenue;
//		this.jdbcTemplateRevenue = new JdbcTemplate(dataSourceRevenue);
//	}
//
//	public DataSource getDataSourceRevenue() {
//		return dataSourceRevenue;
//	}
//
//	public void setJdbcTemplateRevenue(JdbcTemplate jdbcTemplateRevenue) {
//		this.jdbcTemplateRevenue = jdbcTemplateRevenue;
//	}
//
//	public JdbcTemplate getJdbcTemplateRevenue() {
//		return jdbcTemplateRevenue;
//	}
//
//	// ------------ Added by Anwar for LOI Payment on 18-May-2011-----------//
//	// For LOI Demand Print
//
//	private static final class LOIDemandHeaderMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiDemandDto loiReceiptDto = new LoiDemandDto();
//
//			loiReceiptDto.setMailingAddressLine1(rs.getString("asmt_adrs_1"));
//			loiReceiptDto.setMailingAddressLine2(rs.getString("address"));
//			loiReceiptDto.setOwnerName1(rs.getString("owner1"));
//			loiReceiptDto.setOwnerName2(rs.getString("owner2"));
//			loiReceiptDto.setOwnerName3(rs.getString("owner3"));
//			loiReceiptDto.setOwnerName4(rs.getString("owner4"));
//			loiReceiptDto.setOwnerName5(rs.getString("owner5"));
//			loiReceiptDto.setOwnerName6(rs.getString("owner6"));
//			loiReceiptDto.setOwnerName7(rs.getString("owner7"));
//			loiReceiptDto.setOwnerName8(rs.getString("owner8"));
//			loiReceiptDto.setOwnerName9(rs.getString("owner9"));
//			loiReceiptDto.setOwnerName10(rs.getString("owner10"));
//			loiReceiptDto.setPremisesNo(rs.getString("asmt_prem_no"));
//			loiReceiptDto.setStreetName(rs.getString("com_street_name"));
//			loiReceiptDto.setPrintingDate(rs.getString("printed_on"));
//			loiReceiptDto.setTotalInWords(rs.getString("total_in_words"));
//			loiReceiptDto.setTotalWaivedInWords(rs.getString("totalWaived_in_words"));
//
//			return loiReceiptDto;
//		}
//	}
//
//	private static final class LOIDishonourMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiDemandDto loiDemandDto = new LoiDemandDto();
//
//			loiDemandDto.setDishonourAmount(rs.getString("dishonour_amount"));
//
//			return loiDemandDto;
//		}
//	}
//
//	private static final class LOIDemandBodyMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiDemandDto loiReceiptDto = new LoiDemandDto();
//
//			/*
//			 * loiReceiptDto.setBillType(rs.getString("asmt_bill_type"));
//			 * 
//			 * String sTemp1 = rs.getString("from_qtr"); //
//			 * System.out.println("sTemp1="+sTemp1); String sTemp11 = sTemp1.substring(4);
//			 * // System.out.println("sTemp11="+sTemp11); String sTemp12 =
//			 * sTemp1.substring(0,4); // System.out.println("sTemp12="+sTemp12); String
//			 * sTempFromQtr = sTemp11+"/"+sTemp12; //
//			 * System.out.println("sTempFromQtr="+sTempFromQtr);
//			 * 
//			 * String sTemp2 = rs.getString("to_qtr"); //
//			 * System.out.println("sTemp2="+sTemp2); String sTemp21 = sTemp2.substring(4);
//			 * // System.out.println("sTemp21="+sTemp21); String sTemp22 =
//			 * sTemp2.substring(0,4); // System.out.println("sTemp22="+sTemp22); String
//			 * sTempToQtr = sTemp21+"/"+sTemp22; //
//			 * System.out.println("sTempToQtr="+sTempToQtr);
//			 * loiReceiptDto.setFromQtr(sTempFromQtr); loiReceiptDto.setToQtr(sTempToQtr);
//			 * 
//			 * 
//			 */
//
//			// System.out.println("1");
//			loiReceiptDto.setRebateDate(rs.getString("ASMT_REBATE_DATE"));
//			loiReceiptDto.setAv(rs.getString("ASMT_AV"));
//			loiReceiptDto.setPayable(rs.getString("ASMT_PAYABLE_AMT"));
//			loiReceiptDto.setFromQtr(rs.getString("FROM_QTR"));
//			System.out.println("ASMT_BILL_TYPE=" + rs.getString("ASMT_BILL_TYPE") + "--------setFromQtr="
//					+ rs.getString("FROM_QTR"));
//			loiReceiptDto.setNetAmount(rs.getString("ASMT_PAYABLE_AMT"));
//			// System.out.println("3");
//			loiReceiptDto.setBillType(rs.getString("ASMT_BILL_TYPE"));
//			// System.out.println("4");
//			loiReceiptDto.setShareType(rs.getString("ASMT_SHARE_TYPE"));
//			// System.out.println("5");
//			loiReceiptDto.setToQtr(rs.getString("TO_QTR"));
//			// System.out.println("1");
//			loiReceiptDto.setBillNo("1");
//			// System.out.println("7");
//			loiReceiptDto.setGrossAmount(rs.getString("ASMT_PAYABLE_AMT"));
//			// System.out.println("8");
//
//			return loiReceiptDto;
//		}
//	}
//
//	public KMCPortalServiceReturnObject printLOIDemand(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		LoiDemandDto loiDemandDto = new LoiDemandDto();
//		HashMap returnMap = new HashMap();
//		// System.out.println("Within printLOIDemand of KMCPortalAssesmentDAO");
//
//		String assNo = (String) infoMap.get("ASSESSENO");
//		String totalAmt = (String) infoMap.get("totalAmt");
//		String totalWithWaived = (String) infoMap.get("totalAmtWaived");
//		// System.out.println("LOI totalWithWaived="+totalWithWaived);
//		// System.out.println("LOI totalAmt="+totalAmt);
//		String sWardNo = assNo.substring(2, 5);
//		// System.out.println("sWardNo="+sWardNo);
//
//		String totalPayable = (String) infoMap.get("totalPayable");
//		String totalInterest = (String) infoMap.get("totalInterest");
//		String totalPenalty = (String) infoMap.get("totalPenalty");
//
//		loiDemandDto.setPrintPayableAmount(totalPayable);
//		loiDemandDto.setPrintInterestAmount(totalInterest);
//		loiDemandDto.setPrintPenaltyAmount(totalPenalty);
//		String schemeType = (String) infoMap.get("SCHEMETYPE");
//		String suspAmt = (String) infoMap.get("SUSPENSEAMOUNT");
//
//		loiDemandDto.setSchemeType(schemeType);
//		loiDemandDto.setSuspenseAmount(suspAmt);
//
//		String sql = KMCAssessmentLOIConstants.DEMAND_HDR();
//		List arrayList2 = new ArrayList();
//		arrayList2 = jdbcTemplate.query(sql, new Object[] { totalAmt, totalWithWaived, assNo },
//				new LOIDemandHeaderMapper());
//		// System.out.println("arrayList2.size()=="+arrayList2.size());
//
//		if (arrayList2.size() > 0) {
//			LoiDemandDto _loiReceipt = (LoiDemandDto) arrayList2.get(0);
//
//			loiDemandDto.setMailingAddressLine1(_loiReceipt.getMailingAddressLine1());
//			loiDemandDto.setMailingAddressLine2(_loiReceipt.getMailingAddressLine2());
//			loiDemandDto.setOwnerName1(_loiReceipt.getOwnerName1());
//			loiDemandDto.setOwnerName2(_loiReceipt.getOwnerName2());
//			loiDemandDto.setOwnerName3(_loiReceipt.getOwnerName3());
//			loiDemandDto.setOwnerName4(_loiReceipt.getOwnerName4());
//			loiDemandDto.setOwnerName5(_loiReceipt.getOwnerName5());
//			loiDemandDto.setOwnerName6(_loiReceipt.getOwnerName6());
//			loiDemandDto.setOwnerName7(_loiReceipt.getOwnerName7());
//			loiDemandDto.setOwnerName8(_loiReceipt.getOwnerName8());
//			loiDemandDto.setOwnerName9(_loiReceipt.getOwnerName9());
//			loiDemandDto.setOwnerName10(_loiReceipt.getOwnerName10());
//			loiDemandDto.setPremisesNo(_loiReceipt.getPremisesNo());
//			loiDemandDto.setStreetName(_loiReceipt.getStreetName());
//			loiDemandDto.setPrintingDate(_loiReceipt.getPrintingDate());
//			loiDemandDto.setTotalInWords(_loiReceipt.getTotalInWords());
//			loiDemandDto.setTotalWaivedInWords(_loiReceipt.getTotalWaivedInWords());
//
//		}
//
//		loiDemandDto.setFinYear(UtilityForAll.getCurrentFinYear());
//		loiDemandDto.setAssesseeNo(assNo);
//		loiDemandDto.setTotalOutstandingAmt(totalAmt);
//		loiDemandDto.setTotalWithWaived(totalWithWaived);
//		loiDemandDto.setBarcode(assNo + "00000000000000000000002000000000");
//
//		System.out.println("LOI barcode after change=" + loiDemandDto.getBarcode());
//
//		ResultSet rsOffice = null;
//		Connection conn = null;
//		String officeCode = "";
//		PreparedStatement psOffice = null;
//		try {
//			String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//			conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//			psOffice = conn.prepareStatement(KMCAssessmentPaymentConstants.ASMT_OFFICE_CODE_WARD);
//			psOffice.setString(1, sWardNo);
//			rsOffice = psOffice.executeQuery();
//			while (rsOffice.next()) {
//				officeCode = rsOffice.getString(1);
//			}
//			if (officeCode == null) {
//				officeCode = "2";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (rsOffice != null)
//					rsOffice.close();
//
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("LOI officeCode=" + officeCode);
//
//		String sFinYear = (UtilityForAll.getCurrentFinYear()).substring(0, 4);
//		// System.out.println("sFinYear="+sFinYear);
//		// sql = KMCAssessmentLOIConstants.DEMAND_BODY_LIST_WITHOUT_WAIVED();
//
//		if (schemeType != null && (schemeType.equals("WAIVER") || schemeType.equals("WAIVER60"))) {
//			sql = KMCAssessmentLOIConstants.DEMAND_BODY_LIST_WAIVER();
//		} else {
//			sql = KMCAssessmentLOIConstants.DEMAND_BODY_LIST();
//		}
//
//		List dueListTotal = new ArrayList();
//		dueListTotal = jdbcTemplate.query(sql,
//				new Object[] { assNo, officeCode, sWardNo, assNo, officeCode, sWardNo, sFinYear },
//				new LOIDemandBodyMapper());
//		// System.out.println("dueListTotal.size()=="+dueListTotal.size());
//
//		List arrayList4 = new ArrayList();
//		List dueListCombined = new ArrayList();
//		BigDecimal totalNetAmount = new BigDecimal(0);
//		if (dueListTotal.size() > 0) {
//
//			/*
//			 * for(int i=0;i<arrayList3.size();i++) { LoiDemandDto loiDemandDto1 =
//			 * (LoiDemandDto)arrayList3.get(i);
//			 * 
//			 * String datToday = UtilityForAll.getTodaysDate(); String payableamount =
//			 * loiDemandDto1.getPayable(); String sRebateDate =
//			 * loiDemandDto1.getRebateDate(); String
//			 * billingQtr=KMCAssessmentUtility.getPresentQtrFromDate(sRebateDate); String av
//			 * = loiDemandDto1.getAv(); String outStandingDate =
//			 * KMCAssessmentUtility.getOutstandingDateOfStorageQtr(billingQtr);
//			 * 
//			 * String penaltyAmount=""; String interestAmount=""; BigDecimal netAmount=new
//			 * BigDecimal(0); HashMap penaltyAmountMap = new HashMap(); HashMap
//			 * interestAmountMap = new HashMap();
//			 * 
//			 * if(UtilityForAll.compareDates(datToday,outStandingDate)!=1) {
//			 * loiDemandDto1.setNetAmount(payableamount); loiDemandDto1.setInterest("0.00");
//			 * loiDemandDto1.setPenalty("0.00"); } else {
//			 * penaltyAmountMap.put("demandAmount",payableamount);
//			 * penaltyAmountMap.put("qtr",billingQtr);
//			 * penaltyAmountMap.put("todayDate",datToday);
//			 * interestAmountMap.put("demandAmount",payableamount);
//			 * interestAmountMap.put("annualValuation",av);
//			 * interestAmountMap.put("todayDate",datToday);
//			 * interestAmountMap.put("outStandingDate",outStandingDate);
//			 * 
//			 * getPenaltyAmount(penaltyAmountMap); getInterestAmount(interestAmountMap);
//			 * 
//			 * BigDecimal _dpenaltyAmount=(BigDecimal)penaltyAmountMap.get("penaltyAmount");
//			 * //
//			 * System.out.println("_dpenaltyAmount before penalty waved="+_dpenaltyAmount);
//			 * BigDecimal wavedPenalty = new BigDecimal("0.01"); //added by Anwar for 99%
//			 * penalty waved _dpenaltyAmount = _dpenaltyAmount.multiply(wavedPenalty);
//			 * _dpenaltyAmount=_dpenaltyAmount.setScale(2,BigDecimal.ROUND_DOWN); //
//			 * System.out.println("_dpenaltyAmount after penalty waved="+_dpenaltyAmount);
//			 * penaltyAmount = String.valueOf(_dpenaltyAmount); BigDecimal
//			 * _dinterestAmount=(BigDecimal)interestAmountMap.get("interestAmount");
//			 * interestAmount = String.valueOf(_dinterestAmount); netAmount=new
//			 * BigDecimal(Double.parseDouble(payableamount)+
//			 * Double.parseDouble(penaltyAmount)+ Double.parseDouble(interestAmount));
//			 * netAmount=netAmount.setScale(0,BigDecimal.ROUND_HALF_UP);
//			 * 
//			 * // System.out.println("interestAmount="+interestAmount); //
//			 * System.out.println("netAmount="+netAmount+"--Value of I="+i);
//			 * 
//			 * loiDemandDto1.setNetAmount(String.valueOf(netAmount));
//			 * loiDemandDto1.setInterest(interestAmount);
//			 * loiDemandDto1.setPenalty(penaltyAmount); }
//			 * 
//			 * arrayList4.add(loiDemandDto1);
//			 * 
//			 * 
//			 * } System.out.println("arrayList4.size()=="+arrayList4.size());
//			 * 
//			 */
//
//		}
//
//		// loiDemandDto.setListDemandDetails(arrayList4);
//
//		// -------------------------------------------------//
//
//		try {
//			boolean lastFlg = false;
//			LoiDemandDto newDTO = new LoiDemandDto();
//			int count = 0;
//			// System.out.println("size:::::"+dueListTotal.size());
//			for (int i = 0; i < dueListTotal.size(); i++) {
//				LoiDemandDto searchDTO = (LoiDemandDto) dueListTotal.get(i);
//				if (dueListTotal.size() > 1 && i < dueListTotal.size() - 1) {
//					LoiDemandDto nextSearchDTO = (LoiDemandDto) dueListTotal.get(i + 1);
//
//					/// System.out.println(i+"--anwar1::"+new
//					/// Double(searchDTO.getNetAmount()).doubleValue());
//					// System.out.println(i+"--anwar2::"+new
//					/// Double(nextSearchDTO.getNetAmount()).doubleValue());
//
//					// System.out.println(i+"--anwar11::"+searchDTO.getBillType());
//					// System.out.println(i+"--anwar21::"+nextSearchDTO.getBillType());
//					// System.out.println(i+"--anwar11::"+searchDTO.getShareType());
//					// System.out.println(i+"--anwar22::"+nextSearchDTO.getShareType());
//					// System.out.println(i+"--anwar13::"+new
//					// Integer(nextSearchDTO.getFromQtr()).intValue());
//					// System.out.println(i+"--anwar24::"+new
//					// Integer(KMCAssessmentUtility.getNextQtr(searchDTO.getFromQtr())).intValue());
//
//					if ((searchDTO.getBillType().equalsIgnoreCase(nextSearchDTO.getBillType()))
//							&& (searchDTO.getShareType().equalsIgnoreCase(nextSearchDTO.getShareType()))
//							&& (new Double(searchDTO.getNetAmount())
//									.doubleValue() == new Double(nextSearchDTO.getNetAmount()).doubleValue())
//							&& (new Integer(nextSearchDTO.getFromQtr())
//									.intValue() == new Integer(KMCAssessmentUtility.getNextQtr(searchDTO.getFromQtr()))
//											.intValue())) {
//						count++;
//						// System.out.println("count123::"+count);
//						if (count == 1) {
//							newDTO = new LoiDemandDto();
//							newDTO.setFromQtr(searchDTO.getFromQtr());
//						}
//						// System.out.println("HELLO---->"+nextSearchDTO.getFromQtr());
//						newDTO.setBillType(searchDTO.getBillType());
//						newDTO.setShareType(searchDTO.getShareType());
//
//						/////////////////////////////////////////
//
//						String datToday = UtilityForAll.getTodaysDate();
//						String payableamount = searchDTO.getPayable();
//						String sRebateDate = searchDTO.getRebateDate();
//						String billingQtr = KMCAssessmentUtility.getPresentQtrFromDate(sRebateDate);
//						String av = searchDTO.getAv();
//						String outStandingDate = KMCAssessmentUtility.getOutstandingDateOfStorageQtr(billingQtr);
//
//						String penaltyAmount = "";
//						String interestAmount = "";
//						BigDecimal netAmount = new BigDecimal(0);
//						HashMap penaltyAmountMap = new HashMap();
//						HashMap interestAmountMap = new HashMap();
//
//						if (UtilityForAll.compareDates(datToday, outStandingDate) != 1) {
//							// searchDTO.setNetAmount(payableamount);
//						} else {
//							penaltyAmountMap.put("demandAmount", payableamount);
//							penaltyAmountMap.put("qtr", billingQtr);
//							penaltyAmountMap.put("todayDate", datToday);
//							interestAmountMap.put("demandAmount", payableamount);
//							interestAmountMap.put("annualValuation", av);
//							interestAmountMap.put("todayDate", datToday);
//							interestAmountMap.put("outStandingDate", outStandingDate);
//
//							getPenaltyAmount(penaltyAmountMap);
//							getInterestAmount(interestAmountMap);
//
//							BigDecimal _dpenaltyAmount = (BigDecimal) penaltyAmountMap.get("penaltyAmount");
//							// System.out.println("_dpenaltyAmount before penalty waved="+_dpenaltyAmount);
//							// BigDecimal wavedPenalty = new BigDecimal("0.01"); //added by Anwar for 99%
//							// penalty waved
//							// _dpenaltyAmount = _dpenaltyAmount.multiply(wavedPenalty);
//							// _dpenaltyAmount=_dpenaltyAmount.setScale(2,BigDecimal.ROUND_DOWN);
//							// System.out.println("_dpenaltyAmount after penalty waved="+_dpenaltyAmount);
//							penaltyAmount = String.valueOf(_dpenaltyAmount);
//							BigDecimal _dinterestAmount = (BigDecimal) interestAmountMap.get("interestAmount");
//							interestAmount = String.valueOf(_dinterestAmount);
//							// netAmount=new BigDecimal(Double.parseDouble(payableamount)+
//							// Double.parseDouble(penaltyAmount)+
//							// Double.parseDouble(interestAmount));
//
//							netAmount = new BigDecimal(Double.parseDouble(payableamount));
//							netAmount = netAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//
//							searchDTO.setNetAmount(String.valueOf(netAmount));
//							// System.out.println("netAmount="+netAmount+"--Value of I="+i+"--Value of
//							// qtr="+searchDTO.getFromQtr());
//						}
//
//						//////////////////////////////////////////
//
//						newDTO.setNetAmount(searchDTO.getNetAmount());
//						newDTO.setToQtr(nextSearchDTO.getFromQtr());
//						newDTO.setBillNo(String.valueOf(count + 1));
//						// newDTO.setGrossAmount(String.valueOf(AssessmentUtility.convertoSpecifiedPlacesOfDecimal((new
//						// Double(searchDTO.getNetAmount()).doubleValue()*new
//						// Double(count+1).doubleValue()),2)));
//						newDTO.setGrossAmount(String
//								.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(count + 1)))
//										.setScale(2, BigDecimal.ROUND_HALF_UP)));
//
//						if (i == dueListTotal.size() - 2) {
//							dueListCombined.add(newDTO);
//							lastFlg = true;
//						}
//
//					} else {
//						// System.out.println("count:::"+count+"i=="+i);
//						/*
//						 * if(i==dueListTotal.size()-2){ dueListCombined.add(nextSearchDTO); }
//						 */
//						// if(count==0 && i!=dueListTotal.size()-2){
//						if (count == 0) {
//							searchDTO.setGrossAmount(String
//									.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(1)))
//											.setScale(2, BigDecimal.ROUND_HALF_UP))); // added by anwar
//							dueListCombined.add(searchDTO);
//							// System.out.println("Net 1="+searchDTO.getNetAmount());
//						}
//						// if(i>0 && count>0 && i!=dueListTotal.size()-1){
//						if (i > 0 && count > 0) {
//							dueListCombined.add(newDTO);
//						}
//
//						count = 0;
//					}
//				} else if (dueListTotal.size() == 1) {
//					searchDTO.setToQtr(searchDTO.getFromQtr());
//					searchDTO.setBillNo("1");
//					// searchDTO.setGrossAmount(String.valueOf(AssessmentUtility.convertoSpecifiedPlacesOfDecimal((new
//					// Double(searchDTO.getNetAmount()).doubleValue()*new
//					// Double(1).doubleValue()),2)));
//					searchDTO.setGrossAmount(
//							String.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(1)))
//									.setScale(2, BigDecimal.ROUND_HALF_UP)));
//
//					dueListCombined.add(searchDTO);
//
//				}
//				// System.out.println("lastFlg::"+lastFlg);
//				if (!lastFlg && i == (dueListTotal.size() - 1) && dueListTotal.size() != 1) {
//					searchDTO.setToQtr(searchDTO.getFromQtr());
//					searchDTO.setBillNo("1");
//					// searchDTO.setGrossAmount(String.valueOf(AssessmentUtility.convertoSpecifiedPlacesOfDecimal((new
//					// Double(searchDTO.getNetAmount()).doubleValue()*new
//					// Double(1).doubleValue()),2)));
//					searchDTO.setGrossAmount(
//							String.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(1)))
//									.setScale(2, BigDecimal.ROUND_HALF_UP)));
//					// System.out.println("Net 2="+searchDTO.getNetAmount());
//					dueListCombined.add(searchDTO);
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		List listFinal = new ArrayList();
//		for (int i = 0; i < dueListCombined.size(); i++) {
//			LoiDemandDto searchDTO = (LoiDemandDto) dueListCombined.get(i);
//
//			String sTemp1 = searchDTO.getFromQtr();
//			String sTemp11 = sTemp1.substring(4);
//			String sTemp12 = sTemp1.substring(0, 4);
//			String sTempFromQtr = sTemp11 + "/" + sTemp12;
//			sTempFromQtr = sTempFromQtr + "-"
//					+ (Integer.parseInt(sTempFromQtr.substring(sTempFromQtr.indexOf("/") + 1)) + 1);
//			searchDTO.setFromQtr(sTempFromQtr);
//			// System.out.println("sTempFromQtr="+sTempFromQtr);
//
//			String sTemp2 = searchDTO.getToQtr();
//			String sTemp21 = sTemp2.substring(4);
//			String sTemp22 = sTemp2.substring(0, 4);
//			String sTempToQtr = sTemp21 + "/" + sTemp22;
//			sTempToQtr = sTempToQtr + "-" + (Integer.parseInt(sTempToQtr.substring(sTempToQtr.indexOf("/") + 1)) + 1);
//			searchDTO.setToQtr(sTempToQtr);
//			// System.out.println("sTempToQtr="+sTempToQtr);
//
//			// ---------------------//
//			BigDecimal bNetAmount = new BigDecimal(searchDTO.getNetAmount());
//			bNetAmount = bNetAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//			searchDTO.setNetAmount(String.valueOf(bNetAmount));
//
//			BigDecimal bGrossAmount = new BigDecimal(searchDTO.getGrossAmount());
//			bGrossAmount = bGrossAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//			searchDTO.setGrossAmount(String.valueOf(bGrossAmount));
//
//			// -----------------------//
//
//			listFinal.add(searchDTO);
//		}
//
//		// --------------------------------------------------//
//
//		// System.out.println("Size of dueListCombined="+dueListCombined.size());
//		// System.out.println("Size of listFinal="+listFinal.size());
//		loiDemandDto.setListDemandDetails(listFinal);
//
//		sql = KMCAssessmentLOIConstants.DISHONOURAMOUNT();
//		List arrayList6 = new ArrayList();
//		arrayList6 = jdbcTemplate.query(sql, new Object[] { assNo }, new LOIDishonourMapper());
//		// System.out.println("arrayList6.size()=="+arrayList6.size());
//
//		if (arrayList6.size() > 0) {
//			LoiDemandDto _loiDemand = (LoiDemandDto) arrayList6.get(0);
//
//			loiDemandDto.setDishonourAmount(_loiDemand.getDishonourAmount());
//		}
//
//		returnMap.put(KMCAssessmentLOIConstants.PrintAppConstants.LOI_DEMAND, loiDemandDto);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		return _obj;
//	}
//
//	// For LOI Receipt Print
//
//	private static final class LOIReceiptTxnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//			loiReceiptDto.setAssesseeNo(rs.getString("asmt_assno"));
//			loiReceiptDto.setWardNo(rs.getString("asmt_ward_no"));
//			loiReceiptDto.setReceiptNo(rs.getString("txn_recpt_no"));
//			loiReceiptDto.setAsmtShemeType(rs.getString("asmt_scheme_type"));
//			loiReceiptDto.setSuspenseAmt(rs.getString("asmt_suspense_amt"));
//			return loiReceiptDto;
//		}
//	}
//
//	private static final class LOIWaiverReceiptTxnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//			loiReceiptDto.setAssesseeNo(rs.getString("asmt_assno"));
//			loiReceiptDto.setWardNo(rs.getString("asmt_ward_no"));
//			loiReceiptDto.setReceiptNo(rs.getString("txn_recpt_no"));
//			return loiReceiptDto;
//		}
//	}
//
//	private static final class LOIReceiptHeaderMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//
//			loiReceiptDto.setPaidBy(rs.getString("ASMT_PAID_BY"));
//
//			if (rs.getString("asmt_pin_code") != null) {
//				loiReceiptDto.setPinCode("PIN CODE : " + rs.getString("asmt_pin_code"));
//			}
//			if (rs.getString("ASMT_PERSON_LIABLE") != null) {
//				loiReceiptDto.setPersonLiable("PERSON LIABLE TO PAY TAX : " + rs.getString("ASMT_PERSON_LIABLE"));
//			}
//
//			loiReceiptDto.setMailingAddressLine1(rs.getString("address"));
//
//			loiReceiptDto.setOwnerName1(rs.getString("owner1"));
//			loiReceiptDto.setOwnerName2(rs.getString("owner2"));
//			loiReceiptDto.setOwnerName3(rs.getString("owner3"));
//			loiReceiptDto.setOwnerName4(rs.getString("owner4"));
//			loiReceiptDto.setOwnerName5(rs.getString("owner5"));
//			loiReceiptDto.setOwnerName6(rs.getString("owner6"));
//			loiReceiptDto.setOwnerName7(rs.getString("owner7"));
//			loiReceiptDto.setOwnerName8(rs.getString("owner8"));
//			loiReceiptDto.setOwnerName9(rs.getString("owner9"));
//			loiReceiptDto.setOwnerName10(rs.getString("owner10"));
//
//			loiReceiptDto.setTotalAmt(rs.getString("receiptAmount"));
//			loiReceiptDto.setPremisesNo(rs.getString("asmt_prem_no"));
//			loiReceiptDto.setStreetName(rs.getString("com_street_name"));
//			loiReceiptDto.setReceiptDate(rs.getString("create_date"));
//			loiReceiptDto.setPrintingDate(rs.getString("printed_on"));
//			loiReceiptDto.setAmtInWords(rs.getString("amtWords"));
//
//			return loiReceiptDto;
//		}
//	}
//
//	private static final class LOIReceiptBodyMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//
//			loiReceiptDto.setBillType(rs.getString("asmt_bill_type"));
//			loiReceiptDto.setShareType(rs.getString("asmt_share_type"));
//
//			loiReceiptDto.setFromQtrNew(rs.getString("asmt_from_qtr"));
//			loiReceiptDto.setToQtrNew(rs.getString("asmt_to_qtr"));
//
//			System.out.println("asmt_from_qtr=" + rs.getString("asmt_from_qtr"));
//			// System.out.println("111111111111");
//			String sTemp1 = rs.getString("asmt_from_qtr");
//			String sTemp2 = "";
//			if (sTemp1 != null) {
//				System.out.println("sTemp1=" + sTemp1);
//				sTemp2 = sTemp1.substring(4) + "/" + sTemp1.substring(0, 4);
//				System.out.println("sTemp2=" + sTemp2);
//			}
//
//			// Added on 24/09/2014
//			sTemp2 = sTemp2 + "-" + (Integer.parseInt(sTemp2.substring(sTemp2.indexOf("/") + 1)) + 1);
//			System.out.println("sTemp2=" + sTemp2);
//			loiReceiptDto.setFromQtr(sTemp2);
//
//			String sTemp3 = rs.getString("asmt_to_qtr");
//			String sTemp4 = "";
//			if (sTemp3 != null) {
//				sTemp4 = sTemp3.substring(4) + "/" + sTemp3.substring(0, 4);
//				System.out.println("sTemp4=" + sTemp4);
//			}
//
//			// Added on 24/09/2014
//			sTemp4 = sTemp4 + "-" + (Integer.parseInt(sTemp4.substring(sTemp4.indexOf("/") + 1)) + 1);
//			System.out.println("sTemp4=" + sTemp4);
//			loiReceiptDto.setToQtr(sTemp4);
//
//			loiReceiptDto.setPayable(rs.getString("ASMT_PAYABLE_AMT"));
//			loiReceiptDto.setInterest(rs.getString("asmt_interest_amt"));
//			loiReceiptDto.setPenalty(rs.getString("asmt_penalty_amt"));
//			loiReceiptDto.setNetAmount(rs.getString("net_txn_amt"));
//
//			return loiReceiptDto;
//		}
//	}
//
//	public KMCPortalServiceReturnObject printLOIReceipt(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		LoiReceipt loiReceiptDto = new LoiReceipt();
//		HashMap returnMap = new HashMap();
//		System.out.println("Within printLOIReceipt of KMCPortalAssesmentDAO");
//
//		String transactionID = (String) infoMap.get("TXN_ID");
//		System.out.println("LOI transactionID=" + transactionID);
//		String sAssesseNo = null;
//		String sWardNo = null;
//		String sReceiptNo = null;
//
//		String sql = " select distinct t2.asmt_assno,t2.asmt_ward_no, t1.txn_recpt_no, nvl(t2.asmt_scheme_type, 'NA') asmt_scheme_type, nvl(t2.asmt_suspense_amt, 'NA') asmt_suspense_amt from portal_pgw_txn_parent t1, asmt_pgw_loi_txn t2 where t1.txn_id = ? and t1.txn_status = 'S' and t1.txn_id = t2.txn_id ";
//		List arrayList1 = new ArrayList();
//		arrayList1 = jdbcTemplatePay.query(sql, new Object[] { transactionID }, new LOIReceiptTxnMapper());
//		System.out.println("arrayList1.size()==" + arrayList1.size());
//
//		if (arrayList1.size() > 0) {
//			LoiReceipt _loiReceipt = (LoiReceipt) arrayList1.get(0);
//			loiReceiptDto.setAssesseeNo(_loiReceipt.getAssesseeNo());
//			loiReceiptDto.setWardNo(_loiReceipt.getWardNo());
//			loiReceiptDto.setReceiptNo(_loiReceipt.getReceiptNo());
//			sAssesseNo = _loiReceipt.getAssesseeNo();
//			sWardNo = _loiReceipt.getWardNo();
//			sReceiptNo = _loiReceipt.getReceiptNo();
//			loiReceiptDto.setAsmtShemeType(_loiReceipt.getAsmtShemeType());
//		}
//		System.out.println("LOI sAssesseNo=" + sAssesseNo + "--sWardNo=" + sWardNo + "--sReceiptNo=" + sReceiptNo);
//
//		sql = KMCAssessmentLOIConstants.RECEIPT_HDR();
//		List arrayList2 = new ArrayList();
//		arrayList2 = jdbcTemplate.query(sql, new Object[] { sReceiptNo, sAssesseNo, sWardNo },
//				new LOIReceiptHeaderMapper());
//		System.out.println("arrayList2.size()==" + arrayList2.size());
//
//		if (arrayList2.size() > 0) {
//			LoiReceipt _loiReceipt = (LoiReceipt) arrayList2.get(0);
//
//			loiReceiptDto.setPaidBy(_loiReceipt.getPaidBy());
//			loiReceiptDto.setPersonLiable(_loiReceipt.getPersonLiable());
//			loiReceiptDto.setMailingAddressLine1(_loiReceipt.getMailingAddressLine1());
//			loiReceiptDto.setOwnerName1(_loiReceipt.getOwnerName1());
//			loiReceiptDto.setOwnerName2(_loiReceipt.getOwnerName2());
//			loiReceiptDto.setOwnerName3(_loiReceipt.getOwnerName3());
//			loiReceiptDto.setOwnerName4(_loiReceipt.getOwnerName4());
//			loiReceiptDto.setOwnerName5(_loiReceipt.getOwnerName5());
//			loiReceiptDto.setOwnerName6(_loiReceipt.getOwnerName6());
//			loiReceiptDto.setOwnerName7(_loiReceipt.getOwnerName7());
//			loiReceiptDto.setOwnerName8(_loiReceipt.getOwnerName8());
//			loiReceiptDto.setOwnerName9(_loiReceipt.getOwnerName9());
//			loiReceiptDto.setOwnerName10(_loiReceipt.getOwnerName10());
//			loiReceiptDto.setTotalAmt(_loiReceipt.getTotalAmt());
//			loiReceiptDto.setPremisesNo(_loiReceipt.getPremisesNo());
//			loiReceiptDto.setStreetName(_loiReceipt.getStreetName());
//			loiReceiptDto.setReceiptDate(_loiReceipt.getReceiptDate());
//			loiReceiptDto.setPrintingDate(_loiReceipt.getPrintingDate());
//			loiReceiptDto.setAmtInWords(_loiReceipt.getAmtInWords());
//			loiReceiptDto.setPinCode(_loiReceipt.getPinCode());
//		}
//
//		sql = KMCAssessmentLOIConstants.RECEIPT_BODY_LIST();
//		List arrayList3 = new ArrayList();
//		arrayList3 = jdbcTemplate.query(sql, new Object[] { transactionID }, new LOIReceiptBodyMapper());
//		System.out.println("arrayList3.size()==" + arrayList3.size());
//
//		if (arrayList3.size() > 0) {
//			loiReceiptDto.setListDemandDetails(arrayList3);
//
//		}
//
//		loiReceiptDto.setFinYear(UtilityForAll.getCurrentFinYear());
//
//		loiReceiptDto.setBarcode(transactionID);
//		loiReceiptDto.setTxnId(transactionID);
//		System.out.println("LOI Receipt Barcode after change =" + loiReceiptDto.getBarcode());
//		returnMap.put(KMCAssessmentLOIConstants.PrintAppConstants.LOI_RECEIPT, loiReceiptDto);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		return _obj;
//	}
//
//	// For LOI Receipt Search
//
//	private static final class LoiReceiptSearchMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//
//			loiReceiptDto.setTxnId(rs.getString("TXN_ID"));
//			loiReceiptDto.setReceiptNo(rs.getString("txn_recpt_no"));
//			loiReceiptDto.setReceiptDate(rs.getString("receipt_date"));
//			loiReceiptDto.setTotalAmt(rs.getString("txn_amount"));
//			loiReceiptDto.setTxnType(rs.getString("txn_type"));
//			loiReceiptDto.setPayMode(rs.getString("pay_mode"));
//
//			return loiReceiptDto;
//		}
//	}
//
//	public KMCPortalServiceReturnObject searchDetailsForLOIReceipt(HashMap infoMap) throws KMCPortalBusinessException {
//		// System.out.println("Within searchDetailsForLOIReceipt of
//		// KMCPortalAssessmentDAO");
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getDoc of searchDetailsForLOIReceipt");
//		}
//
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String fromDate = (String) infoMap.get("FROM_DATE");
//		String toDate = (String) infoMap.get("TO_DATE");
//
//		// ----------------------------------------//
//		/*
//		 * String sql = ; List arrayList11 = new ArrayList(); arrayList11 =
//		 * jdbcTemplate.query(sql,new Object[]{fromDate,toDate,assesseeNo},new
//		 * LoiReceiptSearchMapper());
//		 * 
//		 * 
//		 * if(arrayListMonthYear==null || arrayListMonthYear.size()==0) {
//		 * KMCPortalBusinessException busException = new KMCPortalBusinessException();
//		 * busException.setErrMesg("No unpaid demand found against the given StallId ");
//		 * throw busException;
//		 * 
//		 * }
//		 */
//		// ----------------------------------------------//
//
//		String sql = KMCAssessmentLOIConstants.RECEIPT_SEARCH_RESULT();
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { fromDate, toDate, assesseeNo },
//				new LoiReceiptSearchMapper());
//		sql = null;
//		HashMap returnMap = new HashMap();
//
//		System.out.println("arrayList size=" + arrayList.size());
//
//		returnMap.put("RECEIPT_SEARCH_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from searchDetailsForLOIReceipt ");
//		}
//		return _obj;
//	}
//
//	// ------------ End of Added by Anwar for LOI Payment------------------//
//
//	// --------------Added for Address Change----------------------//
//
//	private static final class AddressDetailsMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			AddChangeDto addChangeDto = new AddChangeDto();
//
//			addChangeDto.setAdd1(rs.getString("ASMT_ADRS_1"));
//			addChangeDto.setAdd2(rs.getString("ASMT_ADRS_2"));
//			addChangeDto.setAdd3(rs.getString("ASMT_ADRS_3"));
//			addChangeDto.setAdd4(rs.getString("ASMT_ADRS_4"));
//			addChangeDto.setAdd5(rs.getString("ASMT_ADRS_5"));
//			addChangeDto.setAdd6(rs.getString("ASMT_ADRS_6"));
//			addChangeDto.setAdd7(rs.getString("ASMT_ADRS_7"));
//			addChangeDto.setAdd8(rs.getString("ASMT_ADRS_8"));
//			addChangeDto.setPin(rs.getString("ASMT_PIN_CODE"));
//
//			addChangeDto.setAssNo(rs.getString("ASMT_ASSNO"));
//
//			String sTemp = "";
//			if (rs.getString("ASMT_ASSNO") != null) {
//				sTemp = (rs.getString("ASMT_ASSNO")).substring(2, 5);
//			}
//			addChangeDto.setWard(sTemp);
//
//			addChangeDto.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			addChangeDto.setFlatNo(rs.getString("ASMT_FLAT_NO"));
//			addChangeDto.setMotherAssNo(rs.getString("ASMT_MOTHER_ASSNO"));
//
//			addChangeDto.setOwn1(rs.getString("ASMT_OWN_1"));
//			addChangeDto.setOwn2(rs.getString("ASMT_OWN_2"));
//			addChangeDto.setOwn3(rs.getString("ASMT_OWN_3"));
//			addChangeDto.setOwn4(rs.getString("ASMT_OWN_4"));
//			addChangeDto.setOwn5(rs.getString("ASMT_OWN_5"));
//			addChangeDto.setOwn6(rs.getString("ASMT_OWN_6"));
//			addChangeDto.setOwn7(rs.getString("ASMT_OWN_7"));
//			addChangeDto.setOwn8(rs.getString("ASMT_OWN_8"));
//			addChangeDto.setOwn9(rs.getString("ASMT_OWN_9"));
//			addChangeDto.setOwn10(rs.getString("ASMT_OWN_10"));
//			addChangeDto.setStreet(rs.getString("ASMT_STREET_CODE"));
//
//			System.out.println("01=" + rs.getString("PERSON_LIABLE1"));
//			addChangeDto.setRegistrationNo(rs.getString("PERSON_LIABLE1"));
//			System.out.println("11=" + rs.getString("PERSON_LIABLE1"));
//
//			addChangeDto.setHertitageId(rs.getString("ASMT_HERTITAGE_ID"));
//			addChangeDto.setPondId(rs.getString("ASMT_POND_ID"));
//			addChangeDto.setCharacterOfPremise(rs.getString("ASMT_CHARACTER_OF_PREMISE"));
//
//			return addChangeDto;
//		}
//	}
//
//	public KMCPortalServiceReturnObject getAddressDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getAddressDetails of DAO 111");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getAddressDetails of KMCPortalWaiverDAO");
//		}
//
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String sWardNo = assesseeNo.substring(2, 5);
//
//		String sql = KMCAssessmentAddChangeConstants.GET_ASSESSEE_DETAILS();
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { assesseeNo, sWardNo }, new AddressDetailsMapper());
//		sql = null;
//		HashMap returnMap = new HashMap();
//
//		if (arrayList == null || arrayList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No Record Found for the given Assessee.");
//			throw _busException;
//		}
//
//		returnMap.put("ASSESSEE_DETAILS_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from getAddressDetails of KMCPortalWaiverDAO ");
//		}
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject getMutaAddressDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getAddressDetails of DAO 111");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getAddressDetails of KMCPortalWaiverDAO");
//		}
//
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String sWardNo = assesseeNo.substring(2, 5);
//
//		String nocFlag = (String) infoMap.get("NOCFLAG");
//
//		String sql = KMCAssessmentAddChangeConstants.GET_ASSESSEE_DETAILS();
//		System.out.println(sql);
//		String sql2 = KMCAssessmentAddChangeConstants.GET_BLDG_COMPLETION_CASE_NO();
//		String sql1 = KMCAssessmentAddChangeConstants.GET_BLDG_SANCTION_NO();
//		String sql3 = KMCAssessmentAddChangeConstants.GET_OTHER_DETAILS();
//		String sql4 = KMCAssessmentAddChangeConstants.GET_EFFECTIVE_DATE();
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { assesseeNo, sWardNo }, new AddressDetailsMapper());
//
//		System.out.println(arrayList);
//
//		Connection conn = null;
//		PreparedStatement ps = null;
//		PreparedStatement ps1 = null;
//		PreparedStatement ps2 = null;
//		PreparedStatement ps3 = null;
//		ResultSet rs = null;
//		ResultSet rs1 = null;
//		ResultSet rs2 = null;
//		ResultSet rs3 = null;
//		String bldgSanctionNo = null;
//		String bldgCompletionCaseNo = null;
//		String personLiable = null;
//		String av = null;
//		String streetName = null;
//		String effectiveDate = null;
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		try {
//			conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//			ps = conn.prepareStatement(sql1);
//			ps.setString(1, assesseeNo);
//
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				bldgSanctionNo = rs.getString(1);
//			}
//
//			ps1 = conn.prepareStatement(sql2);
//			ps1.setString(1, assesseeNo);
//			ps1.setString(2, bldgSanctionNo);
//
//			rs1 = ps1.executeQuery();
//			while (rs1.next()) {
//				bldgCompletionCaseNo = rs1.getString(1);
//			}
//			ps2 = conn.prepareStatement(sql3);
//			ps2.setString(1, assesseeNo);
//
//			rs2 = ps2.executeQuery();
//			while (rs2.next()) {
//				personLiable = rs2.getString("ASMT_PERSON_LIABLE");
//				av = rs2.getString("ASMT_AV");
//				streetName = rs2.getString("COM_STREET_NAME");
//			}
//
//			ps3 = conn.prepareStatement(sql4);
//			ps3.setString(1, assesseeNo);
//
//			rs3 = ps3.executeQuery();
//			while (rs3.next()) {
//				effectiveDate = rs3.getString(1);
//				System.out.println(effectiveDate);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ps != null)
//					ps.close();
//				if (ps1 != null)
//					ps1.close();
//				if (conn != null)
//					if (ps2 != null)
//						ps2.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//			}
//		}
//
//		AddChangeDto addChangeDto = new AddChangeDto();
//
//		sql = null;
//		HashMap returnMap = new HashMap();
//
//		if (arrayList.size() > 0) {
//			addChangeDto = (AddChangeDto) arrayList.get(0);
//			addChangeDto.setBldgSanctionNo(bldgSanctionNo);
//			addChangeDto.setBldgCompletionCaseNo(bldgCompletionCaseNo);
//			addChangeDto.setNocFlag("Y");
//			addChangeDto.setPersonLiable(personLiable);
//			addChangeDto.setAv(av);
//			addChangeDto.setStreetName(streetName);
//			addChangeDto.setEffectiveDate(effectiveDate);
//			System.out.println(addChangeDto.getCharacterOfPremise());
//			if (addChangeDto.getHertitageId() != null || addChangeDto.getPondId() != null
//					|| addChangeDto.getCharacterOfPremise() != null
//							&& addChangeDto.getCharacterOfPremise().equals("K")) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("Contact Department");
//				throw _busException;
//			}
//		}
//
//		returnMap.put("ASSESSEE_DETAILS_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from getAddressDetails of KMCPortalWaiverDAO ");
//		}
//
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject getMutation(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getMutation of DAO 111");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getMutation of KMCPortalWaiverDAO");
//		}
//
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String sLoginId = (String) infoMap.get("sLoginId");
//
//		String sql = KMCAssessmentAddChangeConstants.GET_MUTATION_DETAILS();
//		System.out.println(sql);
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { assesseeNo, sLoginId }, new MutationStatusMapper());
//
//		System.out.println(arrayList);
//
//		sql = null;
//		HashMap returnMap = new HashMap();
//
//		/*
//		 * if(arrayList==null || arrayList.size()==0) { KMCPortalBusinessException
//		 * _busException = new KMCPortalBusinessException();
//		 * _busException.setErrMesg("No Record Found for the given Assessee."); throw
//		 * _busException; }
//		 */
//
//		returnMap.put("MUTATION_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from getMutation of KMCPortalWaiverDAO ");
//		}
//		return _obj;
//	}
//
//	///////////////////////////////// AddressAssesseeSearchAction added by
//	///////////////////////////////// Suchandra//////////////////////
//	public KMCPortalServiceReturnObject getAddressAssesseeList(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getAddressAssesseeList of assessment dao");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getAddressAssesseeList of assessment DAO");
//		}
//
//		AddressAssesseeSearchDTO addressChangeStatusDTO = new AddressAssesseeSearchDTO();
//		List retList = new ArrayList();
//
//		String wardNo = (String) infoMap.get("WARDNO");
//		String streetNo = (String) infoMap.get("STREETNO");
//		String premisesNo = (String) infoMap.get("PREMISESNO");
//
//		System.out.println("wardNo in assessment DAO =" + wardNo);
//		System.out.println("streetNo in assessment DAO =" + streetNo);
//		System.out.println("premisesNo in assessment DAO=" + premisesNo);
//
//		String sql = "";
//		List arrayListAddressAssesseeInfo = new ArrayList();
//
//		System.out.println("3");
//		sql = KMCAssessmentConstants.get_Address_Assessee_Search();
//		System.out.println("sql =" + sql);
//		try {
//			arrayListAddressAssesseeInfo = jdbcTemplate.query(sql, new Object[] { wardNo, premisesNo, streetNo },
//					new addressAssesseeSeacrhMapper());
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//
//		System.out.println("sql =" + sql);
//		System.out.println("arrayListPenInfo size=" + arrayListAddressAssesseeInfo.size());
//
//		if (arrayListAddressAssesseeInfo.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(" No data exist for the given informations. ");
//			throw _busException;
//		}
//
//		sql = null;
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("ADDRESS_ASSESSEE_LIST", arrayListAddressAssesseeInfo);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	/////////////////////////////// End of
//	/////////////////////////////// AddressAssesseeSearchAction/////////////////////////////////////////////////////////////////////
//	//////////////////////// Added for
//	/////////////////////////////// addressAssesseeSeacrhMapper////////////////////////
//
//	private static final class addressAssesseeSeacrhMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			AddressAssesseeSearchDTO addressAssesseeSearchDTO = new AddressAssesseeSearchDTO();
//			////////////////////////////
//
//			addressAssesseeSearchDTO.setAsmtassno(rs.getString("asmt_assno"));
//			addressAssesseeSearchDTO
//					.setAsmtflatno(rs.getString("asmt_flat_no") != null ? rs.getString("asmt_flat_no") : "");
//			addressAssesseeSearchDTO.setAsmtown1(rs.getString("OWNER") != null ? rs.getString("OWNER") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown2(rs.getString("asmt_own_2") != null ? rs.getString("asmt_own_2") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown3(rs.getString("asmt_own_3") != null ? rs.getString("asmt_own_3") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown4(rs.getString("asmt_own_4") != null ? rs.getString("asmt_own_4") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown5(rs.getString("asmt_own_5") != null ? rs.getString("asmt_own_5") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown6(rs.getString("asmt_own_6") != null ? rs.getString("asmt_own_6") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown7(rs.getString("asmt_own_7") != null ? rs.getString("asmt_own_7") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown8(rs.getString("asmt_own_8") != null ? rs.getString("asmt_own_8") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown9(rs.getString("asmt_own_9") != null ? rs.getString("asmt_own_9") + " " : "");
//			addressAssesseeSearchDTO
//					.setAsmtown10(rs.getString("asmt_own_10") != null ? rs.getString("asmt_own_10") : "");
//			addressAssesseeSearchDTO.setAsmtpersonliable(rs.getString("PERSON_LIABLE"));
//
//			return addressAssesseeSearchDTO;
//		}
//	}
//	/////////////////////////////// End of
//	/////////////////////////////// addressAssesseeSeacrhMapper//////////////////////////////////
//
//	public KMCPortalServiceReturnObject updateAddress(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within updateAddress");
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into updateAddress of KMCPortalWaiverDAO");
//		}
//
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String sWardNo = assesseeNo.substring(2, 5);
//		System.out.println("assesseeNo=" + assesseeNo);
//		System.out.println("sWardNo=" + sWardNo);
//
//		String address1 = (String) infoMap.get("ADDRESS1");
//		String address2 = (String) infoMap.get("ADDRESS2");
//		String address3 = (String) infoMap.get("ADDRESS3");
//		String address4 = (String) infoMap.get("ADDRESS4");
//		String address5 = (String) infoMap.get("ADDRESS5");
//		String address6 = (String) infoMap.get("ADDRESS6");
//		String address7 = (String) infoMap.get("ADDRESS7");
//		String address8 = (String) infoMap.get("ADDRESS8");
//		String pin1 = (String) infoMap.get("PIN1");
//		String docs = (String) infoMap.get("DOCS");
//
//		System.out.println("In DAO address1=" + address1);
//		System.out.println("In DAO address8=" + address8);
//
//		String sql = KMCAssessmentAddChangeConstants.GET_ASSESSEE_DETAILS();
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { assesseeNo, sWardNo, address1, address2, address3, address4,
//				address5, address6, address7, address8, pin1, docs }, new AddressDetailsMapper());
//		sql = null;
//		HashMap returnMap = new HashMap();
//
//		System.out.println("arrayList size=" + arrayList.size());
//
//		returnMap.put("ASSESSEE_DETAILS_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from updateAddress ");
//		}
//		return _obj;
//	}
//
//	// --------------End of Added for Address Change----------------------//
//
//	// ----------------------- Added for Waiver ------------------------//
//
//	private static final class WaiverAssessmentCurrentRowMapper implements RowMapper {
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			String todaysDate = UtilityForAll.getTodaysDate();
//			DemandCollectionDTO demandCollectionDTO = (DemandCollectionDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.DemandCollectionDTO");
//			demandCollectionDTO.setBillNo(rs.getString("asmt_bill_no"));
//			demandCollectionDTO.setPhysicalBillNo(rs.getString("asmt_physical_bill_no"));
//			demandCollectionDTO.setPresentationDate(rs.getString("asmt_presentation_date"));
//			demandCollectionDTO.setBillType(rs.getString("asmt_bill_type"));
//			demandCollectionDTO
//					.setFromQtr(KMCAssessmentUtility.convertEffQuarterFromStorageToView(rs.getString("from_qtr")));
//			demandCollectionDTO
//					.setToQtr(KMCAssessmentUtility.convertEffQuarterFromStorageToView(rs.getString("to_qtr")));
//			String grossAmt = rs.getString("ASMT_PAYABLE_AMT");
//			grossAmt = String.valueOf(Math.round(new Double(grossAmt).doubleValue()));
//			demandCollectionDTO.setGrossAmount(grossAmt);
//			demandCollectionDTO.setShareType(rs.getString("asmt_share_type"));
//			demandCollectionDTO.setSelectAll("");
//			demandCollectionDTO.setSelectFlag("");
//			demandCollectionDTO.setClubbedBill("NO");
//			demandCollectionDTO.setAV(rs.getString("ASMT_AV"));
//			demandCollectionDTO.setFreshBillNo(rs.getString("ASMT_FS_BILL_NO"));
//			String rebateDate = rs.getString("asmt_rebate_date");
//			if (grossAmt == null || grossAmt == "")
//				grossAmt = new Double(0).toString();
//			demandCollectionDTO.setRebateDate(rebateDate);
//			return demandCollectionDTO;
//
//		}// end of method
//
//	}
//
//	public String getPresentationUptoDate() {
//		Connection conn = null;
//		PreparedStatement psDate = null;
//		ResultSet rs = null;
//		String sRetDate = "";
//
//		try {
//			String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_CONNECTION;
//			conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//			psDate = conn.prepareStatement(" select t.presentation_upto from waiver_date t");
//			rs = psDate.executeQuery();
//			while (rs.next()) {
//				sRetDate = rs.getString("presentation_upto");
//			}
//		} catch (Exception ex) {
//
//		} finally {
//			try {
//				if (psDate != null)
//					psDate.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException ex) {
//
//			}
//		}
//		return sRetDate;
//	}
//
//	private static final class AssCheckRowmapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			DemandCollectionDTO demandCollectionDTO = (DemandCollectionDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.DemandCollectionDTO");
//
//			String sAssStatus = rs.getString("asmt_status");
//			if (sAssStatus == null || sAssStatus == "") {
//				sAssStatus = "ok";
//			}
//			demandCollectionDTO.setAssStatus(sAssStatus);
//			sAssStatus = null;
//			return demandCollectionDTO;
//
//		}
//	}
//
//	public KMCPortalServiceReturnObject getWaiverDemandDetailsForOutStandingCollection(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		System.out.println("Within getWaiverDemandDetailsForOutStandingCollection of KMCPortalAssessmentDAO");
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		List retList = new ArrayList();
//		List retListAssCheck = new ArrayList();
//		String sTempAssCheck = " select t.asmt_status from asmt_asse_mst t where t.asmt_assno = ? ";
//		retListAssCheck = jdbcTemplate.query(sTempAssCheck, new Object[] { _assesseeNo }, new AssCheckRowmapper());
//		if (retListAssCheck.size() > 0) {
//			DemandCollectionDTO demandCollectionDTO = (DemandCollectionDTO) retListAssCheck.get(0);
//			String sTempAssStatus = demandCollectionDTO.getAssStatus();
//
//			if (sTempAssStatus.equalsIgnoreCase("ok")) {
//				String wardNo = _assesseeNo.substring(2, 5);
//				String sPresUptoDate = getPresentationUptoDate();
//				System.out.println("sPresUptoDate=" + sPresUptoDate);
//				WaiverAssessmentCurrentRowMapper _outRowmapper = new WaiverAssessmentCurrentRowMapper();
//
//				String sqlQuery = KMCAssessmentConstants.getWaiverOutStandingDemandForAssess();
//				String todate = UtilityForAll.getTodaysDate();
//				String year = KMCAssessmentUtility.getCurrentFinYear();
//				retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo, todate, sPresUptoDate,
//						_assesseeNo, wardNo, year.substring(0, 4), sPresUptoDate }, _outRowmapper);
//				if (retList == null || retList.size() == 0) {
//					KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//					_busException.setErrMesg("No outstanding demand exist for the given assessee");
//					throw _busException;
//				}
//
//			} else {
//				if (sTempAssStatus.equalsIgnoreCase("DELETED")) {
//					KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//					_busException.setErrMesg("This assessee is deleted");
//					throw _busException;
//				} else if (sTempAssStatus.equalsIgnoreCase("P")) {
//					KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//					_busException.setErrMesg("This assessee is proposed");
//					throw _busException;
//				} else {
//					KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//					_busException.setErrMesg("This assessee is blocked");
//					throw _busException;
//				}
//
//			}
//		}
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	private static final class WaiverLOIDemandHeaderMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiDemandDto loiReceiptDto = new LoiDemandDto();
//
//			loiReceiptDto.setMailingAddressLine1(rs.getString("asmt_adrs_1"));
//			loiReceiptDto.setMailingAddressLine2(rs.getString("address"));
//			loiReceiptDto.setOwnerName1(rs.getString("owner1"));
//			loiReceiptDto.setOwnerName2(rs.getString("owner2"));
//			loiReceiptDto.setOwnerName3(rs.getString("owner3"));
//			loiReceiptDto.setOwnerName4(rs.getString("owner4"));
//			loiReceiptDto.setOwnerName5(rs.getString("owner5"));
//			loiReceiptDto.setOwnerName6(rs.getString("owner6"));
//			loiReceiptDto.setOwnerName7(rs.getString("owner7"));
//			loiReceiptDto.setOwnerName8(rs.getString("owner8"));
//			loiReceiptDto.setOwnerName9(rs.getString("owner9"));
//			loiReceiptDto.setOwnerName10(rs.getString("owner10"));
//			loiReceiptDto.setWaiverPerLiable(rs.getString("asmt_person_liable"));
//			loiReceiptDto.setPremisesNo(rs.getString("asmt_prem_no"));
//			loiReceiptDto.setStreetName(rs.getString("com_street_name"));
//			loiReceiptDto.setPrintingDate(rs.getString("printed_on"));
//			loiReceiptDto.setTotalInWords(rs.getString("total_in_words"));
//			loiReceiptDto.setTotalWaivedInWords(rs.getString("totalWaived_in_words"));
//
//			return loiReceiptDto;
//		}
//	}
//
//	// Waiver Demand Print
//	public KMCPortalServiceReturnObject printWaiverDemand(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		LoiDemandDto loiDemandDto = new LoiDemandDto();
//		HashMap returnMap = new HashMap();
//		System.out.println("Within printWaiverDemand of KMCPortalAssesmentDAO");
//
//		String assNo = (String) infoMap.get("ASSESSENO");
//		String totalAmt = (String) infoMap.get("totalAmt");
//		String totalWithWaived = (String) infoMap.get("totalAmtWaived");
//		// System.out.println("LOI totalWithWaived="+totalWithWaived);
//		// System.out.println("LOI totalAmt="+totalAmt);
//		String sWardNo = assNo.substring(2, 5);
//		// System.out.println("sWardNo="+sWardNo);
//
//		String sPresUptoDate = getPresentationUptoDate();
//
//		String totalPayable = (String) infoMap.get("totalPayable");
//		String totalInterest = (String) infoMap.get("totalInterest");
//		String totalPenalty = (String) infoMap.get("totalPenalty");
//
//		loiDemandDto.setPrintPayableAmount(totalPayable);
//		loiDemandDto.setPrintInterestAmount(totalInterest);
//		loiDemandDto.setPrintPenaltyAmount(totalPenalty);
//
//		String sql = KMCAssessmentLOIConstants.WAIVER_DEMAND_HDR();
//		List arrayList2 = new ArrayList();
//		arrayList2 = jdbcTemplate.query(sql, new Object[] { totalAmt, totalWithWaived, assNo },
//				new WaiverLOIDemandHeaderMapper());
//		// System.out.println("arrayList2.size()=="+arrayList2.size());
//
//		if (arrayList2.size() > 0) {
//			LoiDemandDto _loiReceipt = (LoiDemandDto) arrayList2.get(0);
//
//			loiDemandDto.setMailingAddressLine1(_loiReceipt.getMailingAddressLine1());
//			loiDemandDto.setMailingAddressLine2(_loiReceipt.getMailingAddressLine2());
//			loiDemandDto.setOwnerName1(_loiReceipt.getOwnerName1());
//			loiDemandDto.setOwnerName2(_loiReceipt.getOwnerName2());
//			loiDemandDto.setOwnerName3(_loiReceipt.getOwnerName3());
//			loiDemandDto.setOwnerName4(_loiReceipt.getOwnerName4());
//			loiDemandDto.setOwnerName5(_loiReceipt.getOwnerName5());
//			loiDemandDto.setOwnerName6(_loiReceipt.getOwnerName6());
//			loiDemandDto.setOwnerName7(_loiReceipt.getOwnerName7());
//			loiDemandDto.setOwnerName8(_loiReceipt.getOwnerName8());
//			loiDemandDto.setOwnerName9(_loiReceipt.getOwnerName9());
//			loiDemandDto.setOwnerName10(_loiReceipt.getOwnerName10());
//			loiDemandDto.setWaiverPerLiable(_loiReceipt.getWaiverPerLiable());
//			loiDemandDto.setPremisesNo(_loiReceipt.getPremisesNo());
//			loiDemandDto.setStreetName(_loiReceipt.getStreetName());
//			loiDemandDto.setPrintingDate(_loiReceipt.getPrintingDate());
//			loiDemandDto.setTotalInWords(_loiReceipt.getTotalInWords());
//			loiDemandDto.setTotalWaivedInWords(_loiReceipt.getTotalWaivedInWords());
//
//		}
//
//		loiDemandDto.setFinYear(UtilityForAll.getCurrentFinYear());
//		loiDemandDto.setAssesseeNo(assNo);
//		loiDemandDto.setTotalOutstandingAmt(totalAmt);
//		loiDemandDto.setTotalWithWaived(totalWithWaived);
//		loiDemandDto.setBarcode(assNo + "00000000000000000000009000000000");
//
//		System.out.println("Waiver barcode after change=" + loiDemandDto.getBarcode());
//
//		ResultSet rsOffice = null;
//		Connection conn = null;
//		String officeCode = "";
//		PreparedStatement psOffice = null;
//		try {
//			String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//			conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//			psOffice = conn.prepareStatement(KMCAssessmentPaymentConstants.ASMT_OFFICE_CODE_WARD);
//			psOffice.setString(1, sWardNo);
//			rsOffice = psOffice.executeQuery();
//			while (rsOffice.next()) {
//				officeCode = rsOffice.getString(1);
//			}
//			if (officeCode == null) {
//				officeCode = "2";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (rsOffice != null)
//					rsOffice.close();
//
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("LOI officeCode=" + officeCode);
//
//		String sFinYear = (UtilityForAll.getCurrentFinYear()).substring(0, 4);
//		// System.out.println("sFinYear="+sFinYear);
//		// sql = KMCAssessmentLOIConstants.DEMAND_BODY_LIST_WITHOUT_WAIVED();
//		sql = KMCAssessmentLOIConstants.Print_Waiver_DEMAND_BODY_LIST();
//
//		List dueListTotal = new ArrayList();
//		dueListTotal = jdbcTemplate.query(sql, new Object[] { assNo, officeCode, sWardNo, sPresUptoDate, assNo,
//				officeCode, sWardNo, sFinYear, sPresUptoDate }, new LOIDemandBodyMapper());
//		// System.out.println("dueListTotal.size()=="+dueListTotal.size());
//
//		List arrayList4 = new ArrayList();
//		List dueListCombined = new ArrayList();
//		BigDecimal totalNetAmount = new BigDecimal(0);
//		if (dueListTotal.size() > 0) {
//
//			/*
//			 * for(int i=0;i<arrayList3.size();i++) { LoiDemandDto loiDemandDto1 =
//			 * (LoiDemandDto)arrayList3.get(i);
//			 * 
//			 * String datToday = UtilityForAll.getTodaysDate(); String payableamount =
//			 * loiDemandDto1.getPayable(); String sRebateDate =
//			 * loiDemandDto1.getRebateDate(); String
//			 * billingQtr=KMCAssessmentUtility.getPresentQtrFromDate(sRebateDate); String av
//			 * = loiDemandDto1.getAv(); String outStandingDate =
//			 * KMCAssessmentUtility.getOutstandingDateOfStorageQtr(billingQtr);
//			 * 
//			 * String penaltyAmount=""; String interestAmount=""; BigDecimal netAmount=new
//			 * BigDecimal(0); HashMap penaltyAmountMap = new HashMap(); HashMap
//			 * interestAmountMap = new HashMap();
//			 * 
//			 * if(UtilityForAll.compareDates(datToday,outStandingDate)!=1) {
//			 * loiDemandDto1.setNetAmount(payableamount); loiDemandDto1.setInterest("0.00");
//			 * loiDemandDto1.setPenalty("0.00"); } else {
//			 * penaltyAmountMap.put("demandAmount",payableamount);
//			 * penaltyAmountMap.put("qtr",billingQtr);
//			 * penaltyAmountMap.put("todayDate",datToday);
//			 * interestAmountMap.put("demandAmount",payableamount);
//			 * interestAmountMap.put("annualValuation",av);
//			 * interestAmountMap.put("todayDate",datToday);
//			 * interestAmountMap.put("outStandingDate",outStandingDate);
//			 * 
//			 * getPenaltyAmount(penaltyAmountMap); getInterestAmount(interestAmountMap);
//			 * 
//			 * BigDecimal _dpenaltyAmount=(BigDecimal)penaltyAmountMap.get("penaltyAmount");
//			 * //
//			 * System.out.println("_dpenaltyAmount before penalty waved="+_dpenaltyAmount);
//			 * BigDecimal wavedPenalty = new BigDecimal("0.01"); //added by Anwar for 99%
//			 * penalty waved _dpenaltyAmount = _dpenaltyAmount.multiply(wavedPenalty);
//			 * _dpenaltyAmount=_dpenaltyAmount.setScale(2,BigDecimal.ROUND_DOWN); //
//			 * System.out.println("_dpenaltyAmount after penalty waved="+_dpenaltyAmount);
//			 * penaltyAmount = String.valueOf(_dpenaltyAmount); BigDecimal
//			 * _dinterestAmount=(BigDecimal)interestAmountMap.get("interestAmount");
//			 * interestAmount = String.valueOf(_dinterestAmount); netAmount=new
//			 * BigDecimal(Double.parseDouble(payableamount)+
//			 * Double.parseDouble(penaltyAmount)+ Double.parseDouble(interestAmount));
//			 * netAmount=netAmount.setScale(0,BigDecimal.ROUND_HALF_UP);
//			 * 
//			 * // System.out.println("interestAmount="+interestAmount); //
//			 * System.out.println("netAmount="+netAmount+"--Value of I="+i);
//			 * 
//			 * loiDemandDto1.setNetAmount(String.valueOf(netAmount));
//			 * loiDemandDto1.setInterest(interestAmount);
//			 * loiDemandDto1.setPenalty(penaltyAmount); }
//			 * 
//			 * arrayList4.add(loiDemandDto1);
//			 * 
//			 * 
//			 * } System.out.println("arrayList4.size()=="+arrayList4.size());
//			 * 
//			 */
//
//		}
//
//		// loiDemandDto.setListDemandDetails(arrayList4);
//
//		// -------------------------------------------------//
//
//		try {
//			boolean lastFlg = false;
//			LoiDemandDto newDTO = new LoiDemandDto();
//			int count = 0;
//			// System.out.println("size:::::"+dueListTotal.size());
//			for (int i = 0; i < dueListTotal.size(); i++) {
//				LoiDemandDto searchDTO = (LoiDemandDto) dueListTotal.get(i);
//				if (dueListTotal.size() > 1 && i < dueListTotal.size() - 1) {
//					LoiDemandDto nextSearchDTO = (LoiDemandDto) dueListTotal.get(i + 1);
//
//					/// System.out.println(i+"--anwar1::"+new
//					/// Double(searchDTO.getNetAmount()).doubleValue());
//					// System.out.println(i+"--anwar2::"+new
//					/// Double(nextSearchDTO.getNetAmount()).doubleValue());
//
//					// System.out.println(i+"--anwar11::"+searchDTO.getBillType());
//					// System.out.println(i+"--anwar21::"+nextSearchDTO.getBillType());
//					// System.out.println(i+"--anwar11::"+searchDTO.getShareType());
//					// System.out.println(i+"--anwar22::"+nextSearchDTO.getShareType());
//					// System.out.println(i+"--anwar13::"+new
//					// Integer(nextSearchDTO.getFromQtr()).intValue());
//					// System.out.println(i+"--anwar24::"+new
//					// Integer(KMCAssessmentUtility.getNextQtr(searchDTO.getFromQtr())).intValue());
//
//					if ((searchDTO.getBillType().equalsIgnoreCase(nextSearchDTO.getBillType()))
//							&& (searchDTO.getShareType().equalsIgnoreCase(nextSearchDTO.getShareType()))
//							&& (new Double(searchDTO.getNetAmount())
//									.doubleValue() == new Double(nextSearchDTO.getNetAmount()).doubleValue())
//							&& (new Integer(nextSearchDTO.getFromQtr())
//									.intValue() == new Integer(KMCAssessmentUtility.getNextQtr(searchDTO.getFromQtr()))
//											.intValue())) {
//						count++;
//						// System.out.println("count123::"+count);
//						if (count == 1) {
//							newDTO = new LoiDemandDto();
//							newDTO.setFromQtr(searchDTO.getFromQtr());
//						}
//						// System.out.println("HELLO---->"+nextSearchDTO.getFromQtr());
//						newDTO.setBillType(searchDTO.getBillType());
//						newDTO.setShareType(searchDTO.getShareType());
//
//						/////////////////////////////////////////
//
//						String datToday = UtilityForAll.getTodaysDate();
//						String payableamount = searchDTO.getPayable();
//						String sRebateDate = searchDTO.getRebateDate();
//						String billingQtr = KMCAssessmentUtility.getPresentQtrFromDate(sRebateDate);
//						String av = searchDTO.getAv();
//						String outStandingDate = KMCAssessmentUtility.getOutstandingDateOfStorageQtr(billingQtr);
//
//						String penaltyAmount = "";
//						String interestAmount = "";
//						BigDecimal netAmount = new BigDecimal(0);
//						HashMap penaltyAmountMap = new HashMap();
//						HashMap interestAmountMap = new HashMap();
//
//						if (UtilityForAll.compareDates(datToday, outStandingDate) != 1) {
//							// searchDTO.setNetAmount(payableamount);
//						} else {
//							penaltyAmountMap.put("demandAmount", payableamount);
//							penaltyAmountMap.put("qtr", billingQtr);
//							penaltyAmountMap.put("todayDate", datToday);
//							interestAmountMap.put("demandAmount", payableamount);
//							interestAmountMap.put("annualValuation", av);
//							interestAmountMap.put("todayDate", datToday);
//							interestAmountMap.put("outStandingDate", outStandingDate);
//
//							getPenaltyAmount(penaltyAmountMap);
//							getInterestAmount(interestAmountMap);
//
//							BigDecimal _dpenaltyAmount = (BigDecimal) penaltyAmountMap.get("penaltyAmount");
//							// System.out.println("_dpenaltyAmount before penalty waved="+_dpenaltyAmount);
//							// BigDecimal wavedPenalty = new BigDecimal("0.01"); //added by Anwar for 99%
//							// penalty waved
//							// _dpenaltyAmount = _dpenaltyAmount.multiply(wavedPenalty);
//							// _dpenaltyAmount=_dpenaltyAmount.setScale(2,BigDecimal.ROUND_DOWN);
//							// System.out.println("_dpenaltyAmount after penalty waved="+_dpenaltyAmount);
//							penaltyAmount = String.valueOf(_dpenaltyAmount);
//							BigDecimal _dinterestAmount = (BigDecimal) interestAmountMap.get("interestAmount");
//							interestAmount = String.valueOf(_dinterestAmount);
//							// netAmount=new BigDecimal(Double.parseDouble(payableamount)+
//							// Double.parseDouble(penaltyAmount)+
//							// Double.parseDouble(interestAmount));
//
//							netAmount = new BigDecimal(Double.parseDouble(payableamount));
//							netAmount = netAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//
//							searchDTO.setNetAmount(String.valueOf(netAmount));
//							// System.out.println("netAmount="+netAmount+"--Value of I="+i+"--Value of
//							// qtr="+searchDTO.getFromQtr());
//						}
//
//						//////////////////////////////////////////
//
//						newDTO.setNetAmount(searchDTO.getNetAmount());
//						newDTO.setToQtr(nextSearchDTO.getFromQtr());
//						newDTO.setBillNo(String.valueOf(count + 1));
//						// newDTO.setGrossAmount(String.valueOf(AssessmentUtility.convertoSpecifiedPlacesOfDecimal((new
//						// Double(searchDTO.getNetAmount()).doubleValue()*new
//						// Double(count+1).doubleValue()),2)));
//						newDTO.setGrossAmount(String
//								.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(count + 1)))
//										.setScale(2, BigDecimal.ROUND_HALF_UP)));
//
//						if (i == dueListTotal.size() - 2) {
//							dueListCombined.add(newDTO);
//							lastFlg = true;
//						}
//
//					} else {
//						// System.out.println("count:::"+count+"i=="+i);
//						/*
//						 * if(i==dueListTotal.size()-2){ dueListCombined.add(nextSearchDTO); }
//						 */
//						// if(count==0 && i!=dueListTotal.size()-2){
//						if (count == 0) {
//							searchDTO.setGrossAmount(String
//									.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(1)))
//											.setScale(2, BigDecimal.ROUND_HALF_UP))); // added by anwar
//							dueListCombined.add(searchDTO);
//							// System.out.println("Net 1="+searchDTO.getNetAmount());
//						}
//						// if(i>0 && count>0 && i!=dueListTotal.size()-1){
//						if (i > 0 && count > 0) {
//							dueListCombined.add(newDTO);
//						}
//
//						count = 0;
//					}
//				} else if (dueListTotal.size() == 1) {
//					searchDTO.setToQtr(searchDTO.getFromQtr());
//					searchDTO.setBillNo("1");
//					// searchDTO.setGrossAmount(String.valueOf(AssessmentUtility.convertoSpecifiedPlacesOfDecimal((new
//					// Double(searchDTO.getNetAmount()).doubleValue()*new
//					// Double(1).doubleValue()),2)));
//					searchDTO.setGrossAmount(
//							String.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(1)))
//									.setScale(2, BigDecimal.ROUND_HALF_UP)));
//
//					dueListCombined.add(searchDTO);
//
//				}
//				// System.out.println("lastFlg::"+lastFlg);
//				if (!lastFlg && i == (dueListTotal.size() - 1) && dueListTotal.size() != 1) {
//					searchDTO.setToQtr(searchDTO.getFromQtr());
//					searchDTO.setBillNo("1");
//					// searchDTO.setGrossAmount(String.valueOf(AssessmentUtility.convertoSpecifiedPlacesOfDecimal((new
//					// Double(searchDTO.getNetAmount()).doubleValue()*new
//					// Double(1).doubleValue()),2)));
//					searchDTO.setGrossAmount(
//							String.valueOf((new BigDecimal(searchDTO.getNetAmount()).multiply(new BigDecimal(1)))
//									.setScale(2, BigDecimal.ROUND_HALF_UP)));
//					// System.out.println("Net 2="+searchDTO.getNetAmount());
//					dueListCombined.add(searchDTO);
//
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		List listFinal = new ArrayList();
//		for (int i = 0; i < dueListCombined.size(); i++) {
//			LoiDemandDto searchDTO = (LoiDemandDto) dueListCombined.get(i);
//
//			String sTemp1 = searchDTO.getFromQtr();
//			String sTemp11 = sTemp1.substring(4);
//			String sTemp12 = sTemp1.substring(0, 4);
//			String sTempFromQtr = sTemp11 + "/" + sTemp12;
//			searchDTO.setFromQtr(sTempFromQtr);
//			// System.out.println("sTempFromQtr="+sTempFromQtr);
//
//			String sTemp2 = searchDTO.getToQtr();
//			String sTemp21 = sTemp2.substring(4);
//			String sTemp22 = sTemp2.substring(0, 4);
//			String sTempToQtr = sTemp21 + "/" + sTemp22;
//			searchDTO.setToQtr(sTempToQtr);
//			// System.out.println("sTempToQtr="+sTempToQtr);
//
//			// ---------------------//
//			BigDecimal bNetAmount = new BigDecimal(searchDTO.getNetAmount());
//			bNetAmount = bNetAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//			searchDTO.setNetAmount(String.valueOf(bNetAmount));
//
//			BigDecimal bGrossAmount = new BigDecimal(searchDTO.getGrossAmount());
//			bGrossAmount = bGrossAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
//			searchDTO.setGrossAmount(String.valueOf(bGrossAmount));
//
//			// -----------------------//
//
//			listFinal.add(searchDTO);
//		}
//
//		// --------------------------------------------------//
//
//		// System.out.println("Size of dueListCombined="+dueListCombined.size());
//		// System.out.println("Size of listFinal="+listFinal.size());
//		loiDemandDto.setListDemandDetails(listFinal);
//
//		sql = KMCAssessmentLOIConstants.DISHONOURAMOUNT();
//		List arrayList6 = new ArrayList();
//		arrayList6 = jdbcTemplate.query(sql, new Object[] { assNo }, new LOIDishonourMapper());
//		// System.out.println("arrayList6.size()=="+arrayList6.size());
//
//		if (arrayList6.size() > 0) {
//			LoiDemandDto _loiDemand = (LoiDemandDto) arrayList6.get(0);
//
//			loiDemandDto.setDishonourAmount(_loiDemand.getDishonourAmount());
//		}
//
//		// For NB
//		AssessmentCurrentRowMapper _outRowmapper = new AssessmentCurrentRowMapper();
//		List retListEnd = new ArrayList();
//		String sqlQuery = KMCAssessmentConstants.getWaiverNbOutStandingDemandForAssess();
//		String todate = UtilityForAll.getTodaysDate();
//		String year = KMCAssessmentUtility.getCurrentFinYear();
//		// String sPresUptoDate = getPresentationUptoDate();
//		loiDemandDto.setUptoDate(sPresUptoDate);
//		retListEnd = jdbcTemplate.query(sqlQuery, new Object[] { assNo, sWardNo, todate, sPresUptoDate, assNo, sWardNo,
//				year.substring(0, 4), sPresUptoDate }, _outRowmapper);
//		System.out.println("retListEnd size at getDemandDetailsForWaiverLoi=" + retListEnd.size());
//		if (retListEnd != null && retListEnd.size() > 0) {
//			loiDemandDto
//					.setNb(" NB: For this Assessee other demand outside the purview of this waiver scheme exists. ");
//		}
//
//		returnMap.put(KMCAssessmentLOIConstants.PrintAppConstants.LOI_DEMAND, loiDemandDto);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		return _obj;
//	}
//
//	// Waiver Receipt Print
//	public KMCPortalServiceReturnObject printWaiverReceipt(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		LoiReceipt loiReceiptDto = new LoiReceipt();
//		HashMap returnMap = new HashMap();
//		System.out.println("Within printWaiverReceipt of KMCPortalAssesmentDAO");
//
//		String transactionID = (String) infoMap.get("TXN_ID");
//		System.out.println("LOI transactionID=" + transactionID);
//		String sAssesseNo = null;
//		String sWardNo = null;
//		String sReceiptNo = null;
//
//		String sql = " select distinct t2.asmt_assno,t2.asmt_ward_no, t1.txn_recpt_no from portal_pgw_txn_parent t1, asmt_pgw_waiver_loi_txn t2 where t1.txn_id = ? and t1.txn_status = 'S' and t1.txn_id = t2.txn_id ";
//		List arrayList1 = new ArrayList();
//		arrayList1 = jdbcTemplatePay.query(sql, new Object[] { transactionID }, new LOIWaiverReceiptTxnMapper());
//		System.out.println("arrayList1.size()==" + arrayList1.size());
//
//		if (arrayList1.size() > 0) {
//			LoiReceipt _loiReceipt = (LoiReceipt) arrayList1.get(0);
//			loiReceiptDto.setAssesseeNo(_loiReceipt.getAssesseeNo());
//			loiReceiptDto.setWardNo(_loiReceipt.getWardNo());
//			loiReceiptDto.setReceiptNo(_loiReceipt.getReceiptNo());
//			sAssesseNo = _loiReceipt.getAssesseeNo();
//			sWardNo = _loiReceipt.getWardNo();
//			sReceiptNo = _loiReceipt.getReceiptNo();
//		}
//		// System.out.println("Waiver LOI
//		// sAssesseNo="+sAssesseNo+"--sWardNo="+sWardNo+"--sReceiptNo="+sReceiptNo);
//
//		sql = KMCAssessmentLOIConstants.RECEIPT_HDR();
//		List arrayList2 = new ArrayList();
//		arrayList2 = jdbcTemplate.query(sql, new Object[] { sReceiptNo, sAssesseNo, sWardNo },
//				new LOIReceiptHeaderMapper());
//		System.out.println("arrayList2.size()==" + arrayList2.size());
//
//		if (arrayList2.size() > 0) {
//			LoiReceipt _loiReceipt = (LoiReceipt) arrayList2.get(0);
//
//			loiReceiptDto.setPaidBy(_loiReceipt.getPaidBy());
//			loiReceiptDto.setPersonLiable(_loiReceipt.getPersonLiable());
//			loiReceiptDto.setMailingAddressLine1(_loiReceipt.getMailingAddressLine1());
//			loiReceiptDto.setOwnerName1(_loiReceipt.getOwnerName1());
//			loiReceiptDto.setOwnerName2(_loiReceipt.getOwnerName2());
//			loiReceiptDto.setOwnerName3(_loiReceipt.getOwnerName3());
//			loiReceiptDto.setOwnerName4(_loiReceipt.getOwnerName4());
//			loiReceiptDto.setOwnerName5(_loiReceipt.getOwnerName5());
//			loiReceiptDto.setOwnerName6(_loiReceipt.getOwnerName6());
//			loiReceiptDto.setOwnerName7(_loiReceipt.getOwnerName7());
//			loiReceiptDto.setOwnerName8(_loiReceipt.getOwnerName8());
//			loiReceiptDto.setOwnerName9(_loiReceipt.getOwnerName9());
//			loiReceiptDto.setOwnerName10(_loiReceipt.getOwnerName10());
//			loiReceiptDto.setTotalAmt(_loiReceipt.getTotalAmt());
//			loiReceiptDto.setPremisesNo(_loiReceipt.getPremisesNo());
//			loiReceiptDto.setStreetName(_loiReceipt.getStreetName());
//			loiReceiptDto.setReceiptDate(_loiReceipt.getReceiptDate());
//			loiReceiptDto.setPrintingDate(_loiReceipt.getPrintingDate());
//			loiReceiptDto.setAmtInWords(_loiReceipt.getAmtInWords());
//			loiReceiptDto.setPinCode(_loiReceipt.getPinCode());
//		}
//
//		sql = KMCAssessmentLOIConstants.WAIVER_RECEIPT_BODY_LIST();
//		List arrayList3 = new ArrayList();
//		arrayList3 = jdbcTemplate.query(sql, new Object[] { transactionID }, new WaiverLOIReceiptBodyMapper());
//		System.out.println("arrayList3.size()==" + arrayList3.size());
//
//		// ---------------- For receipt body clubbing -------------------------------//
//		List arrayListMerged = new ArrayList();
//		if (arrayList3.size() > 0) {
//			if (arrayList3.size() > 1) {
//				try {
//					boolean lastFlg = false;
//					LoiReceipt newDTO = new LoiReceipt();
//					int count = 0;
//
//					// System.out.println("size:::::"+arrayList3.size());
//
//					// BigDecimal bPaybleAmount1 = new BigDecimal(searchDTO.getGrossAmount());
//					BigDecimal bPaybleAmount1 = new BigDecimal(0);
//					BigDecimal bInterestAmount1 = new BigDecimal(0);
//					BigDecimal bPenaltyAmount1 = new BigDecimal(0);
//					BigDecimal bNetAmount1 = new BigDecimal(0);
//					String sTempToQrt = null;
//					String sTempFromQrt = null;
//
//					for (int i = 0; i < arrayList3.size(); i++) {
//						LoiReceipt searchDTO = (LoiReceipt) arrayList3.get(i);
//
//						if (count == 0) {
//							sTempFromQrt = searchDTO.getFromQtr();
//						}
//
//						if (arrayList3.size() > 1 && i < arrayList3.size() - 1) {
//							LoiReceipt nextSearchDTO = (LoiReceipt) arrayList3.get(i + 1);
//
//							// System.out.println(i+"--anwar11::"+new
//							// Double(searchDTO.getPayable()).doubleValue());
//							// System.out.println(i+"--anwar12::"+new
//							// Double(nextSearchDTO.getPayable()).doubleValue());
//							System.out.println(i + "--anwar21::" + searchDTO.getShareType());
//							System.out.println(i + "--anwar22::" + nextSearchDTO.getShareType());
//							// System.out.println(i+"--anwar31::"+new
//							// Integer(nextSearchDTO.getFromQtrNew()).intValue());
//							// System.out.println(i+"--anwar32::"+new
//							// Integer(KMCAssessmentUtility.getNextQtr(searchDTO.getFromQtrNew())).intValue());
//
//							if ((searchDTO.getBillType().equalsIgnoreCase(nextSearchDTO.getBillType()))
//									&& (searchDTO.getShareType().equalsIgnoreCase(nextSearchDTO.getShareType()))
//									&& (new Double(searchDTO.getPayable())
//											.doubleValue() == new Double(nextSearchDTO.getPayable()).doubleValue())
//									&& (new Integer(nextSearchDTO.getFromQtrNew()).intValue() == new Integer(
//											KMCAssessmentUtility.getNextQtr(searchDTO.getFromQtrNew())).intValue())) {
//								count++;
//								System.out.println("count=" + count);
//								// System.out.println(" 1 bPaybleAmount1="+bPaybleAmount1);
//								bPaybleAmount1 = bPaybleAmount1.add(new BigDecimal(searchDTO.getPayable()));
//								// System.out.println(" 2 bPaybleAmount1="+bPaybleAmount1);
//								// bPaybleAmount1 = bPaybleAmount1.add(new
//								// BigDecimal(nextSearchDTO.getPayable()));
//								// System.out.println(" 3 bPaybleAmount1="+bPaybleAmount1);
//
//								bInterestAmount1 = bInterestAmount1.add(new BigDecimal(searchDTO.getInterest()));
//								bPenaltyAmount1 = bPenaltyAmount1.add(new BigDecimal(searchDTO.getPenalty()));
//								sTempToQrt = searchDTO.getToQtr();
//								bNetAmount1 = bNetAmount1.add(new BigDecimal(searchDTO.getNetAmount()));
//
//								if (i == (arrayList3.size() - 2)) {
//									bPaybleAmount1 = bPaybleAmount1.add(new BigDecimal(nextSearchDTO.getPayable()));
//									bInterestAmount1 = bInterestAmount1
//											.add(new BigDecimal(nextSearchDTO.getInterest()));
//									bPenaltyAmount1 = bPenaltyAmount1.add(new BigDecimal(nextSearchDTO.getPenalty()));
//									bNetAmount1 = bNetAmount1.add(new BigDecimal(nextSearchDTO.getNetAmount()));
//									sTempToQrt = nextSearchDTO.getToQtr();
//
//									searchDTO.setPayable(String.valueOf(bPaybleAmount1));
//									searchDTO.setInterest(String.valueOf(bInterestAmount1));
//									searchDTO.setPenalty(String.valueOf(bPenaltyAmount1));
//									searchDTO.setNetAmount(String.valueOf(bNetAmount1));
//									searchDTO.setToQtr(sTempToQrt);
//									searchDTO.setFromQtr(sTempFromQrt);
//
//									arrayListMerged.add(searchDTO);
//								}
//							} else {
//								if (count > 0) {
//									if (i == (arrayList3.size() - 2)) {
//										bPaybleAmount1 = bPaybleAmount1.add(new BigDecimal(searchDTO.getPayable()));
//										bInterestAmount1 = bInterestAmount1
//												.add(new BigDecimal(searchDTO.getInterest()));
//										bPenaltyAmount1 = bPenaltyAmount1.add(new BigDecimal(searchDTO.getPenalty()));
//										bNetAmount1 = bNetAmount1.add(new BigDecimal(searchDTO.getNetAmount()));
//										sTempToQrt = searchDTO.getToQtr();
//
//										searchDTO.setPayable(String.valueOf(bPaybleAmount1));
//										searchDTO.setInterest(String.valueOf(bInterestAmount1));
//										searchDTO.setPenalty(String.valueOf(bPenaltyAmount1));
//										searchDTO.setNetAmount(String.valueOf(bNetAmount1));
//										searchDTO.setToQtr(sTempToQrt);
//										searchDTO.setFromQtr(sTempFromQrt);
//										arrayListMerged.add(searchDTO);
//
//										count = 0;
//										bPaybleAmount1 = new BigDecimal(0);
//										bInterestAmount1 = new BigDecimal(0);
//										bPenaltyAmount1 = new BigDecimal(0);
//										bNetAmount1 = new BigDecimal(0);
//										sTempToQrt = null;
//										sTempFromQrt = null;
//
//										arrayListMerged.add(nextSearchDTO);
//									} else {
//										bPaybleAmount1 = bPaybleAmount1.add(new BigDecimal(searchDTO.getPayable()));
//										bInterestAmount1 = bInterestAmount1
//												.add(new BigDecimal(searchDTO.getInterest()));
//										bPenaltyAmount1 = bPenaltyAmount1.add(new BigDecimal(searchDTO.getPenalty()));
//										bNetAmount1 = bNetAmount1.add(new BigDecimal(searchDTO.getNetAmount()));
//										sTempToQrt = searchDTO.getToQtr();
//
//										searchDTO.setPayable(String.valueOf(bPaybleAmount1));
//										searchDTO.setInterest(String.valueOf(bInterestAmount1));
//										searchDTO.setPenalty(String.valueOf(bPenaltyAmount1));
//										searchDTO.setNetAmount(String.valueOf(bNetAmount1));
//										searchDTO.setToQtr(sTempToQrt);
//										searchDTO.setFromQtr(sTempFromQrt);
//										arrayListMerged.add(searchDTO);
//										count = 0;
//										bPaybleAmount1 = new BigDecimal(0);
//										bInterestAmount1 = new BigDecimal(0);
//										bPenaltyAmount1 = new BigDecimal(0);
//										bNetAmount1 = new BigDecimal(0);
//										sTempToQrt = null;
//										sTempFromQrt = null;
//									}
//								} else {
//									arrayListMerged.add(searchDTO);
//									if (i == (arrayList3.size() - 2)) {
//										arrayListMerged.add(nextSearchDTO);
//									}
//								}
//							}
//						}
//					}
//
//					// loiReceiptDto.setListDemandDetails(arrayList3);
//					System.out.println("Size of arrayListMerged=" + arrayListMerged.size());
//					loiReceiptDto.setListDemandDetails(arrayListMerged);
//
//				} catch (Exception ex) {
//					ex.printStackTrace();
//				}
//			} else {
//				loiReceiptDto.setListDemandDetails(arrayList3); // if size=1
//			}
//
//		} // end of if(arrayList3.size() > 0)
//
//		// ----------------end of demand merging -------------------------------//
//
//		String sPresUptoDate1 = getPresentationUptoDate();
//		loiReceiptDto.setUptoDate(sPresUptoDate1);
//
//		loiReceiptDto.setFinYear(UtilityForAll.getCurrentFinYear());
//
//		loiReceiptDto.setBarcode(transactionID);
//		loiReceiptDto.setTxnId(transactionID);
//		// System.out.println("Waiver Receipt Barcode after change
//		// ="+loiReceiptDto.getBarcode());
//
//		// For penalty and interest percentage on receipt
//		List arrayListIntPer = new ArrayList();
//		String sqlQuery11 = " select distinct t.asmt_int_percent,t.asmt_pen_percent from asmt_pgw_waiver_loi_txn t where t.txn_id = ? ";
//		arrayListIntPer = jdbcTemplatePay.query(sqlQuery11, new Object[] { transactionID }, new PenPerRowmapper());
//		System.out.println("arrayListIntPer size at print waiver loi receipt =" + arrayListIntPer.size());
//		if (arrayListIntPer != null && arrayListIntPer.size() > 0) {
//			LoiReceipt loiReceiptDtoTemp11 = (LoiReceipt) arrayListIntPer.get(0);
//			loiReceiptDto.setIntPercent(loiReceiptDtoTemp11.getIntPercent());
//			loiReceiptDto.setPenPercent(loiReceiptDtoTemp11.getPenPercent());
//		}
//		sqlQuery11 = null;
//
//		// For AV on NOC
//		List arrayListAv = new ArrayList();
//		String sqlQuery12 = " select t.asmt_av,t.asmt_effective_qtr from asmt_asse_mst t where t.asmt_assno = ? ";
//		arrayListAv = jdbcTemplate.query(sqlQuery12, new Object[] { sAssesseNo }, new AvRowmapper());
//		System.out.println("arrayListAv size at print waiver loi receipt =" + arrayListAv.size());
//		if (arrayListAv != null && arrayListAv.size() > 0) {
//			LoiReceipt loiReceiptDtoTemp12 = (LoiReceipt) arrayListAv.get(0);
//			loiReceiptDto.setAv(loiReceiptDtoTemp12.getAv());
//			loiReceiptDto.setAvDate(loiReceiptDtoTemp12.getAvDate());
//		}
//		sqlQuery12 = null;
//
//		returnMap.put(KMCAssessmentLOIConstants.PrintAppConstants.WAIVER_LOI_RECEIPT, loiReceiptDto);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		return _obj;
//	}
//
//	private static final class AvRowmapper implements RowMapper {
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//			String sTemp1 = rs.getString("asmt_effective_qtr");
//			String sTemp11 = sTemp1.substring(4);
//			String sTemp12 = sTemp1.substring(0, 4);
//			String sTempAvDate = sTemp11 + "/" + sTemp12;
//			loiReceiptDto.setAvDate(sTempAvDate);
//			sTempAvDate = null;
//			loiReceiptDto.setAv(rs.getString("asmt_av"));
//			return loiReceiptDto;
//		}// end of method
//	}
//
//	private static final class PenPerRowmapper implements RowMapper {
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//			loiReceiptDto.setIntPercent(rs.getString("asmt_int_percent"));
//			loiReceiptDto.setPenPercent(rs.getString("asmt_pen_percent"));
//			return loiReceiptDto;
//		}// end of method
//	}
//
//	private static final class WaiverLOIReceiptBodyMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			LoiReceipt loiReceiptDto = new LoiReceipt();
//
//			loiReceiptDto.setBillType(rs.getString("asmt_bill_type"));
//			loiReceiptDto.setShareType(rs.getString("asmt_share_type"));
//
//			loiReceiptDto.setFromQtrNew(rs.getString("asmt_from_qtr"));
//			loiReceiptDto.setToQtrNew(rs.getString("asmt_to_qtr"));
//
//			System.out.println("asmt_from_qtr=" + rs.getString("asmt_from_qtr"));
//			// System.out.println("111111111111");
//			String sTemp1 = rs.getString("asmt_from_qtr");
//			String sTemp2 = "";
//			if (sTemp1 != null) {
//				System.out.println("sTemp1=" + sTemp1);
//				sTemp2 = sTemp1.substring(4) + "/" + sTemp1.substring(0, 4);
//				System.out.println("sTemp2=" + sTemp2);
//			}
//			loiReceiptDto.setFromQtr(sTemp2);
//
//			String sTemp3 = rs.getString("asmt_to_qtr");
//			String sTemp4 = "";
//			if (sTemp3 != null) {
//				sTemp4 = sTemp3.substring(4) + "/" + sTemp3.substring(0, 4);
//				System.out.println("sTemp4=" + sTemp4);
//			}
//			loiReceiptDto.setToQtr(sTemp4);
//
//			loiReceiptDto.setPayable(rs.getString("ASMT_PAYABLE_AMT"));
//			loiReceiptDto.setInterest(rs.getString("asmt_interest_amt"));
//			loiReceiptDto.setPenalty(rs.getString("asmt_penalty_amt"));
//			loiReceiptDto.setNetAmount(rs.getString("net_txn_amt"));
//
//			return loiReceiptDto;
//		}
//	}
//
//	// For Waiver Receipt Search
//
//	public KMCPortalServiceReturnObject searchDetailsForWaiverReceipt(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		System.out.println("Within searchDetailsForWaiverReceipt of KMCPortalAssessmentDAO");
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getDoc of searchDetailsForLOIReceipt");
//		}
//
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String fromDate = (String) infoMap.get("FROM_DATE");
//		String toDate = (String) infoMap.get("TO_DATE");
//
//		String sql = KMCAssessmentLOIConstants.WAIVER_RECEIPT_SEARCH_RESULT();
//		List arrayList = new ArrayList();
//		arrayList = jdbcTemplate.query(sql, new Object[] { fromDate, toDate, assesseeNo },
//				new LoiReceiptSearchMapper());
//		sql = null;
//		HashMap returnMap = new HashMap();
//
//		System.out.println("arrayList size=" + arrayList.size());
//
//		returnMap.put("RECEIPT_SEARCH_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from searchDetailsForLOIReceipt ");
//		}
//		return _obj;
//	}
//	// ------------------- End of Added for Waiver ---------------------//
//
//	// -----------------------added for special LOI-------------------------//
//	public KMCPortalServiceReturnObject getDemandDetailsForSpecialLoi(HashMap infoMap)
//			throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		AssessmentCurrentRowMapper _outRowmapper = new AssessmentCurrentRowMapper();
//
//		List retList1 = new ArrayList();
//		List retList = new ArrayList();
//		// String sqlQuery = KMCAssessmentConstants.getOutStandingDemandForAssess();
//		String sqlQuery = KMCAssessmentConstants.getSpecLoiOutStandingDemandForAssess();
//		String todate = UtilityForAll.getTodaysDate();
//		String year = KMCAssessmentUtility.getCurrentFinYear();
//
//		String sPresUptoDate = getPresentationUptoDate();
//		// System.out.println("Special LOI sPresUptoDate="+sPresUptoDate);
//
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo, todate, sPresUptoDate, _assesseeNo,
//				wardNo, year.substring(0, 4), sPresUptoDate }, _outRowmapper);
//
//		// System.out.println("retList size at
//		// getDemandDetailsForSpecialLoi="+retList.size());
//
//		if (retList != null && retList.size() > 0) {
//
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			// _busException.setErrMesg("No outstanding demand exist for the given
//			// assessee");
//			_busException.setErrMesg(
//					"Outstanding demand upto " + sPresUptoDate + " exist First pay them through special waiver");
//			throw _busException;
//		} else {
//			sqlQuery = KMCAssessmentConstants.getOutStandingDemandForAssess();
//			todate = UtilityForAll.getTodaysDate();
//			year = KMCAssessmentUtility.getCurrentFinYear();
//			retList1 = jdbcTemplate.query(sqlQuery,
//					new Object[] { _assesseeNo, wardNo, todate, _assesseeNo, wardNo, year.substring(0, 4) },
//					_outRowmapper);
//
//			// System.out.println("retList1 size at
//			// getDemandDetailsForSpecialLoi="+retList1.size());
//
//			if (retList1 == null || retList1.size() == 0) {
//				// System.out.println("3");
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("No outstanding demand exist for the given assessee");
//				throw _busException;
//			}
//
//		}
//		_portalServiceReturnObject.setObj(retList1);
//		return _portalServiceReturnObject;
//	}
//	// ------------------------------end of added for special LOI
//	// -------------------//
//
//	// -------------added for pd demand print change ---------------------------//
//	private static final class SuspenseMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			PDDemand _pdBarcodeDetails = new PDDemand();
//			if (rs.getString("principal").equalsIgnoreCase("0") || rs.getString("principal") == null) {
//				_pdBarcodeDetails.setPrincipalLater("NIL");
//			} else {
//				_pdBarcodeDetails.setPrincipalLater(rs.getString("principal"));
//			}
//
//			if (rs.getString("interest").equalsIgnoreCase("0") || rs.getString("interest") == null) {
//				_pdBarcodeDetails.setInterestLater("NIL");
//			} else {
//				_pdBarcodeDetails.setInterestLater(rs.getString("interest"));
//			}
//
//			if (rs.getString("penalty").equalsIgnoreCase("0") || rs.getString("penalty") == null) {
//				_pdBarcodeDetails.setPenaltyLater("NIL");
//			} else {
//				_pdBarcodeDetails.setPenaltyLater(rs.getString("penalty"));
//			}
//
//			if (rs.getString("suspense").equalsIgnoreCase("0") || rs.getString("suspense") == null) {
//				_pdBarcodeDetails.setSuspenseLater("NIL");
//			} else {
//				_pdBarcodeDetails.setSuspenseLater(rs.getString("suspense"));
//			}
//			return _pdBarcodeDetails;
//		}
//	}
//
//	public HashMap getSuspenseForPDPrint(HashMap infoMap) throws KMCPortalBusinessException {
//		// KMCPortalServiceReturnObject _portalServiceReturnObject = new
//		// KMCPortalServiceReturnObject();
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//
//		String sqlQuery = " select nvl(t.loi_payable,0) as principal, nvl(t.loi_penalty,0) as penalty, nvl(t.loi_interest,0) as interest, nvl(t.suspbal,0) as suspense from asmt_pd_final_prn t where t.asmt_assno = ? ";
//		SuspenseMapper suspenseMapper = new SuspenseMapper();
//		List pdSusList = new ArrayList();
//		pdSusList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, suspenseMapper);
//		// System.out.println("Size of pdSusList at dao aaa222 ="+pdSusList.size());
//
//		if (pdSusList.size() > 0) {
//			returnMap.put("pdSusList", pdSusList);
//		} else {
//			List pdSusList1 = new ArrayList();
//			PDDemand _pdBarcodeDetails = new PDDemand();
//			_pdBarcodeDetails.setPrincipalLater("NIL");
//			_pdBarcodeDetails.setInterestLater("NIL");
//			_pdBarcodeDetails.setPenaltyLater("NIL");
//			_pdBarcodeDetails.setSuspenseLater("NIL");
//			pdSusList1.add(_pdBarcodeDetails);
//			returnMap.put("pdSusList", pdSusList1);
//		}
//
//		return returnMap;
//	}
//
//	// -------------end of added for pd demand print change
//	// ---------------------------//
//
//	// Added for address change status search
//	// --------------------------------------//
//
//	public KMCPortalServiceReturnObject addressChangeStatus(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within addressChangeStatus of assessment dao");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into addressChangeStatus of assessment DAO");
//		}
//
//		AddressChangeStatusDTO addressChangeStatusDTO = new AddressChangeStatusDTO();
//		List retList = new ArrayList();
//
//		String sAssNo = (String) infoMap.get("ASSESSENO");
//		String sReqNo = (String) infoMap.get("REQUESTNO");
//		sReqNo = sReqNo.toUpperCase();
//		System.out.println("sAssNo=" + sAssNo);
//		System.out.println("sReqNo=" + sReqNo);
//		List arrayBreakUpDet = new ArrayList();
//
//		String sql = "";
//		List arrayListPenInfo = new ArrayList();
//
//		if (sReqNo == null || sReqNo.equalsIgnoreCase("") || sReqNo.equalsIgnoreCase("")) {
//
//			System.out.println("1");
//
//			sql = KMCAssessmentConstants.getAssesseAddressChangeStatusAss();
//			arrayListPenInfo = jdbcTemplate.query(sql, new Object[] { sAssNo }, new addressChangeStatusMapper());
//
//		} else if (sAssNo == null || sAssNo.equalsIgnoreCase("") || sAssNo.equalsIgnoreCase("")) {
//			System.out.println("2");
//
//			sql = KMCAssessmentConstants.getAssesseAddressChangeStatusReq();
//			arrayListPenInfo = jdbcTemplate.query(sql, new Object[] { sReqNo }, new addressChangeStatusMapper());
//
//		}
//
//		else {
//			System.out.println("3");
//			sql = KMCAssessmentConstants.getAssesseAddressChangeStatusRA();
//			arrayListPenInfo = jdbcTemplate.query(sql, new Object[] { sReqNo, sAssNo },
//					new addressChangeStatusMapper());
//
//		}
//
//		System.out.println("arrayListPenInfo size=" + arrayListPenInfo.size());
//		if (arrayListPenInfo.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(" No data exist for the given informations. ");
//			throw _busException;
//		}
//
//		sql = null;
//		List returnList = new ArrayList();
//		List returnList1 = new ArrayList();
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("LIST", arrayListPenInfo);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	private static final class addressChangeStatusMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			AddressChangeStatusDTO addressChangeStatusDTO = new AddressChangeStatusDTO();
//			addressChangeStatusDTO.setAssesseeNo(rs.getString("asmt_assno"));
//			addressChangeStatusDTO.setRequestNo(rs.getString("asmt_case_id"));
//			addressChangeStatusDTO.setRequestDate(rs.getString("create_date"));
//			addressChangeStatusDTO.setPresentAddress(rs.getString("old_address"));
//			addressChangeStatusDTO.setProposedAddress(rs.getString("new_address"));
//			addressChangeStatusDTO.setStatus(rs.getString("asmt_status"));
//
//			return addressChangeStatusDTO;
//		}
//	}
//	// End of added for address change status search-----------------------------//
//
//	///////////////////////////////////////////////////////////////////////////////
//	// Added for Mutation status search --------------------------------------//
//
//	// Mutation
//	public KMCPortalServiceReturnObject mutationStatus(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within mutationStatus of assessment dao");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into mutationStatus of assessment DAO");
//		}
//
//		AddressChangeStatusDTO addressChangeStatusDTO = new AddressChangeStatusDTO();
//		List retList = new ArrayList();
//
//		String sAssNo = (String) infoMap.get("ASSESSENO");
//		String sReqNo = (String) infoMap.get("REQUESTNO");
//		sReqNo = sReqNo.toUpperCase();
//		System.out.println("sAssNo=" + sAssNo);
//		System.out.println("sReqNo=" + sReqNo);
//		List arrayBreakUpDet = new ArrayList();
//
//		String sql = "";
//		List arrayListPenInfo = new ArrayList();
//
//		System.out.println("3");
//		sql = KMCAssessmentConstants.getAssesseMutStatus();
//		arrayListPenInfo = jdbcTemplate.query(sql, new Object[] { sReqNo, sAssNo }, new addressChangeStatusMapper());
//
//		System.out.println("arrayListPenInfo size=" + arrayListPenInfo.size());
//		if (arrayListPenInfo.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(" No data exist for the given informations. ");
//			throw _busException;
//		}
//
//		sql = null;
//		List returnList = new ArrayList();
//		List returnList1 = new ArrayList();
//		HashMap returnMap = new HashMap();
//		returnMap.put("LIST", arrayListPenInfo);
//		_obj.setReturnMap(returnMap);
//		return _obj;
//	}
//
//	// exemptionStatus
//	public KMCPortalServiceReturnObject exemptionStatus(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within mutationStatus of assessment dao");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into mutationStatus of assessment DAO");
//		}
//
//		AddressChangeStatusDTO addressChangeStatusDTO = new AddressChangeStatusDTO();
//		List retList = new ArrayList();
//
//		String sAssNo = (String) infoMap.get("ASSESSENO");
//		String sReqNo = (String) infoMap.get("REQUESTNO");
//		sReqNo = sReqNo.toUpperCase();
//		System.out.println("sAssNo=" + sAssNo);
//		System.out.println("sReqNo=" + sReqNo);
//		List arrayBreakUpDet = new ArrayList();
//
//		String sql = "";
//		List arrayListPenInfo = new ArrayList();
//
//		System.out.println("3");
//		sql = KMCAssessmentConstants.getAssesseExemptionStatus();
//		arrayListPenInfo = jdbcTemplate.query(sql, new Object[] { sReqNo, sAssNo }, new addressChangeStatusMapper());
//
//		System.out.println("arrayListPenInfo size=" + arrayListPenInfo.size());
//		if (arrayListPenInfo.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(" No data exist for the given informations. ");
//			throw _busException;
//		}
//
//		sql = null;
//		List returnList = new ArrayList();
//		List returnList1 = new ArrayList();
//		HashMap returnMap = new HashMap();
//		returnMap.put("LIST", arrayListPenInfo);
//		_obj.setReturnMap(returnMap);
//		return _obj;
//	}
//
//	// inoutStatus
//	public KMCPortalServiceReturnObject inoutStatus(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within inoutStatus of assessment dao");
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into inoutStatus of assessment DAO");
//		}
//
//		AddressChangeStatusDTO addressChangeStatusDTO = new AddressChangeStatusDTO();
//		List retList = new ArrayList();
//
//		String sAssNo = (String) infoMap.get("ASSESSENO");
//		String sReqNo = (String) infoMap.get("REQUESTNO");
//		sReqNo = sReqNo.toUpperCase();
//		System.out.println("sAssNo=" + sAssNo);
//		System.out.println("sReqNo=" + sReqNo);
//		List arrayBreakUpDet = new ArrayList();
//
//		String sql = "";
//		List arrayListPenInfo = new ArrayList();
//
//		System.out.println("3");
//		sql = KMCAssessmentConstants.getAssesseInOutStatus();
//		arrayListPenInfo = jdbcTemplate.query(sql, new Object[] { sReqNo, sAssNo }, new addressChangeStatusMapper());
//
//		System.out.println("arrayListPenInfo size=" + arrayListPenInfo.size());
//		if (arrayListPenInfo.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(" No data exist for the given informations. ");
//			throw _busException;
//		}
//
//		sql = null;
//		List returnList = new ArrayList();
//		List returnList1 = new ArrayList();
//		HashMap returnMap = new HashMap();
//		returnMap.put("LIST", arrayListPenInfo);
//		_obj.setReturnMap(returnMap);
//		return _obj;
//	}
//
//	///////////////// end of Mutation Status Search
//	///////////////// ////////////////////////////////////
//
////Start of View Uploaded Document search-----------------------------//
//
//	private static final class ViewAttachmentMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			AddressChangeStatusDTO _addressChangeStatusDTO = (AddressChangeStatusDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.AddressChangeStatusDTO");
//			_addressChangeStatusDTO.setCaseId(rs.getString("req_no"));
//			_addressChangeStatusDTO.setFileName(rs.getString("file_name"));
//			_addressChangeStatusDTO.setCreateDate(rs.getString("createdate"));
//
//			return _addressChangeStatusDTO;
//		}
//	}
//
//	public KMCPortalServiceReturnObject viewAttachment(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getGIData of class GIDAO");
//		}
//		try {
//			String caseId = (String) infoMap.get("CASE_ID");
//			String assNo = (String) infoMap.get("ASS_NO");
//
//			System.out.println("assNo::" + assNo);
//			System.out.println("caseId::" + caseId);
//
//			String sql = KMCAssessmentConstants.getViewAttachment();
//			// String ModifiedSql = sql + "MINUS"+sql;
//			List arrayList = new ArrayList();
//			arrayList = jdbcTemplate.query(sql, new Object[] { caseId, assNo }, new ViewAttachmentMapper());
//			sql = null;
//			System.out.println("Arrlist in dao ::::" + arrayList.size());
//			HashMap returnMap = new HashMap();
//
//			returnMap.put("ATTACHED_LIST", arrayList);
//			_obj.setReturnMap(returnMap);
//			infoMap = null;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from getGIData of class GIDAO");
//		}
//		return _obj;
//	}
//
//	// End of View Uploaded Document search-----------------------------//
//
//	// Start of View Uploaded Document search-----------------------------//
//
//	public KMCPortalServiceReturnObject viewMutAttachment(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into getGIData of class GIDAO");
//		}
//		try {
//			String slNo = (String) infoMap.get("SL_No"); // Added by Soumita
//			String docId = (String) infoMap.get("DOC_ID");// Added by Soumita
//
//			System.out.println("slNo::" + slNo);// Added by Soumita
//			System.out.println("docId::" + docId);// Added by Soumita
//
//			String sql = KMCAssessmentConstants.getMutaViewAttachment();
//			// String ModifiedSql = sql + "MINUS"+sql;
//			List arrayList = new ArrayList();
//			arrayList = jdbcTemplate.query(sql, new Object[] { slNo, docId }, new ViewAttachmentMapper());
//			sql = null;
//			System.out.println("Arrlist in dao ::::" + arrayList.size());
//			HashMap returnMap = new HashMap();
//
//			returnMap.put("ATTACHED_LIST", arrayList);
//			_obj.setReturnMap(returnMap);
//			infoMap = null;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving from getGIData of class GIDAO");
//		}
//		return _obj;
//	}
//
//	// End of View Uploaded Document search-----------------------------//
//
//	public KMCPortalServiceReturnObject getAppPurposeList(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getAppPurposeList of sor dao");
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//
//		String purposeNo = (String) infoMap.get("purposeNo");
//		System.out.println("APP_SL_NO::::" + purposeNo);
//
//		List arrayList = new ArrayList();
//		String sql = KMCAssessmentAddChangeConstants.GET_APPLICATION_PURPOSE();
//		arrayList = jdbcTemplate.query(sql, new ApplicationPurposeListMapper());
//		System.out.println("arrayList1.size()==" + arrayList.size());
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PURPOSE_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		return _obj;
//	}
//
//	// Added by Soumita
//	public KMCPortalServiceReturnObject getPremisesList(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getPremisesList of sor dao");
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//
//		String surcrgUsgId = (String) infoMap.get("surcrgUsgId");
//		System.out.println("surcrgUsgId::::" + surcrgUsgId);
//
//		List arrayList = new ArrayList();
//		String sql = KMCAssessmentAddChangeConstants.GET_PREMISES_DETAILS();
//		arrayList = jdbcTemplate.query(sql, new PremisesListMapper());
//		System.out.println("arrayList1.size()==" + arrayList.size());
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PREMISES_LIST", arrayList);
//		_obj.setReturnMap(returnMap);
//		infoMap = null;
//
//		return _obj;
//	}
//
//	// Added by Soumita
//	public KMCPortalServiceReturnObject getDocumentList(HashMap infoMap) throws KMCPortalBusinessException {
//		System.out.println("Within getDocumentList of sor dao");
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//
//		String appSlNo = (String) infoMap.get("APP_SL_NO");
//		System.out.println("APP_SL_NO::::" + appSlNo);
//
//		List arrayList = new ArrayList();
//		String sql = KMCAssessmentAddChangeConstants.GET_DOCUMENT_LIST(appSlNo);
//		arrayList = jdbcTemplate.query(sql, new DocDetailMapper());
//		System.out.println("arrayList1.size()==" + arrayList.size());
//
//		HashMap returnMap = new HashMap();
//		if (!arrayList.isEmpty()) {
//			returnMap.put("DOCUMENT_LIST", arrayList);
//			_obj.setReturnMap(returnMap);
//		} else {
//			arrayList.add("No records selected");
//			returnMap.put("DOCUMENT_LIST", arrayList);
//			_obj.setReturnMap(returnMap);
//		}
//		infoMap = null;
//
//		return _obj;
//	}
//	////////////////////////// ******************/////////////////////////////////////////
//
//	/**************
//	 * Added By Ananya For mutation Print Start
//	 ******************************/
//
//	/**************** For Muta_Status_Search Page Starts **************/
//
//	private static final class AssessmentMutaStatusSearchRowMapper implements RowMapper {
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			String todaysDate = UtilityForAll.getTodaysDate();
//			MutaStatusDTO mutaStatusDTO = (MutaStatusDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.MutaStatusDTO");
//			// System.out.println("Sizeof ResultSet is " +rs);
//			mutaStatusDTO.setCaseNo(rs.getString("ASMT_CASE_NO"));
//			mutaStatusDTO.setRcptDate(rs.getString("ASMT_RCPT_DATE"));
//			mutaStatusDTO.setAppliedBy(rs.getString("APPLIED_BY"));
//			mutaStatusDTO.setAsmtStatus(rs.getString("ASMT_STATUS"));
//
//			return mutaStatusDTO;
//
//		}
//
//	}
//
//	private static final class MutaStatusSearchExtraInfoRowMapper implements RowMapper {
//		List arraList = new ArrayList();
//
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			String todaysDate = UtilityForAll.getTodaysDate();
//			MutaStatusDTO mutaStatusDTO = (MutaStatusDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.MutaStatusDTO");
//			// System.out.println("Sizeof ResultSet is " +rs);
//			mutaStatusDTO.setHearingDate(rs.getString("ASMT_HEARING_DATE"));
//			mutaStatusDTO.setHearingTime(rs.getString("ASMT_HEARING_TIME"));
//			return mutaStatusDTO;
//
//		}
//
//	}
//
//	/**************** For Muta_Status_Search Page Ends **************/
//
//	private static final class AssessmentMutationPrintRowMapper implements RowMapper {
//		// List arraList = new ArrayList();
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			String todaysDate = UtilityForAll.getTodaysDate();
//			String currYear = KMCAssessmentUtility.getCurrentFinYear();
//			MutationPrintDTO mutationPrintDTO = new MutationPrintDTO();
//			// = (MutationPrintDTO)
//			// DTOFactory.createDTO("com.kmc.portal.dto.business.MutationPrintDTO");
//			// System.out.println("Sizeof ResultSet is " +rs);
//			mutationPrintDTO.setCaseNo(rs.getString("asmt_case_no"));
//			mutationPrintDTO.setDemandDate(rs.getString("DEMAND_DATE"));
//			mutationPrintDTO.setDemandId(rs.getString("ASMT_DEMAND_ID"));
//
//			mutationPrintDTO.setStatus(rs.getString("dmd_status"));
//			// mutationPrintDTO.setMutaType(rs.getString("asmt_muta_type"));
//			mutationPrintDTO.setTotAmount(rs.getString("tot_amount"));
//			// mutationPrintDTO.setFinYear(rs.getString("Fin_Year"));
//			mutationPrintDTO.setFinYear(currYear);
//			mutationPrintDTO.setAssNo(rs.getString("ASMT_ASSNO"));
//			return mutationPrintDTO;
//
//		}
//
//	}
//
//	/*****************
//	 * Added By Ananya For mutation Print End
//	 ********************************/
//
//	/********************
//	 * Added By Ananya For Mutation Print starts
//	 ****************************************************/
//	/************** testing stats ***************************/
//
//	public KMCPortalServiceReturnObject printMut(HashMap passedMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into MutationPrints of DAO");
//		}
//
//		// String _assesseeNo = (String)infoMap.get("ASSESSENO");
//		// String wardNo = _assesseeNo.substring(2,5);
//		// String sqlQuery = KMCAssessmentConstants.GET_ASSESSEE_INFO();
//
//		String _assesseeNo = (String) passedMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//
//		String sqlQuery = KMCAssessmentConstants.GET_ASSESSEE_INFO();
//		System.out.println("In sqlQuery  in DAO sql= " + sqlQuery);
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, wardNo }, new AssesseeInfoMutatnMapper());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid Mutation fees exist for the given assessee for current year");
//			throw _busException;
//		}
//
//		System.out.println("retList.size()=" + retList.size());
//		MutDto mutDto = new MutDto();
//
//		if (retList.size() > 0) {
//			mutDto = (MutDto) retList.get(0);
//		}
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PrintMutation", mutDto);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject printMutaForMoreInfo(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into printMutaForMoreInfo of DAO");
//		}
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//		// String wardNo = _assesseeNo.substring(2,5);
//
//		String sqlQuery = KMCAssessmentConstants.GET_MORE_ASSESSEE_INFO();
//		System.out.println("In sqlQuery  in DAO sql= " + sqlQuery);
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _caseNo },
//				new AssesseeMoreInfoMutatnMapper());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid Mutation fees exist for the given assessee for current year");
//			throw _busException;
//		}
//
//		System.out.println("retList.size()=" + retList.size());
//		MutDto mutDto = new MutDto();
//
//		if (retList.size() > 0) {
//			mutDto = (MutDto) retList.get(0);
//		}
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PrintMoreMutationInfo", mutDto);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	/***************************************/
//
//	/************* testing starts ************************/
//
//	private static final class AssesseeInfoMutatnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutDto _mutDto = new MutDto();
//			_mutDto.setMailingAddressLine1(rs.getString("ASMT_ADRS_1"));
//			_mutDto.setMailingAddressLine2(rs.getString("ASMT_ADRS_2"));
//			_mutDto.setMailingAddressLine3(rs.getString("ASMT_ADRS_3"));
//			// System.out.println("Addrd 3::::"+_pdDemand.getMailingAddressLine3());
//			_mutDto.setMailingAddressLine4(rs.getString("ASMT_ADRS_4"));
//			_mutDto.setMailingAddressLine5(rs.getString("ASMT_ADRS_5"));
//			_mutDto.setMailingAddressLine6(rs.getString("ASMT_ADRS_6"));
//			_mutDto.setMailingAddressLine7(rs.getString("ASMT_ADRS_7"));
//			_mutDto.setMailingAddressLine8(rs.getString("ASMT_ADRS_8"));
//			_mutDto.setPersonLiable(rs.getString("PERSON_LIABLE"));
//			_mutDto.setMailingPinCode(rs.getString("ASMT_PIN_CODE"));
//			_mutDto.setWardNo(rs.getString("ASMT_WARD_NO"));
//			_mutDto.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			_mutDto.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			_mutDto.setStreetName(rs.getString("COM_STREET_NAME"));
//			_mutDto.setOwnerName1(rs.getString("OWNER"));
//			_mutDto.setOwnerName2(rs.getString("ASMT_OWN_2"));
//			_mutDto.setOwnerName3(rs.getString("ASMT_OWN_3"));
//			_mutDto.setOwnerName4(rs.getString("ASMT_OWN_4"));
//			_mutDto.setOwnerName5(rs.getString("ASMT_OWN_5"));
//			_mutDto.setOwnerName6(rs.getString("ASMT_OWN_6"));
//			_mutDto.setOwnerName7(rs.getString("ASMT_OWN_7"));
//			_mutDto.setOwnerName8(rs.getString("ASMT_OWN_8"));
//			_mutDto.setOwnerName9(rs.getString("ASMT_OWN_9"));
//			_mutDto.setOwnerName10(rs.getString("ASMT_OWN_10"));
//
//			return _mutDto;
//		}
//	}
//
//	private static final class AssesseeMoreInfoMutatnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutDto _mutDto = new MutDto();
//			_mutDto.setAsmtCaseNumber(rs.getString("ASMT_CASE_NO"));
//			_mutDto.setAsmtAssno(rs.getString("ASMT_ASSNO"));
//			_mutDto.setOldOwner(rs.getString("OLD_OWNER"));
//			_mutDto.setNewOwner(rs.getString("NEW_OWNER"));
//			_mutDto.setOldAddress(rs.getString("OLD_ADDRESS"));
//			_mutDto.setNewAddress(rs.getString("NEW_ADDRESS"));
//			_mutDto.setAsmtDemandId(rs.getString("ASMT_DEMAND_ID"));
//			_mutDto.setDmdStatus(rs.getString("DMD_STATUS"));
//			_mutDto.setTotAmount(rs.getString("TOT_AMOUNT"));
//			_mutDto.setAsmtRcptDate(rs.getString("ASMT_RCPT_DATE"));
//
//			return _mutDto;
//		}
//	}
//
//	/************* testing ************************/
//
//	private static final class AssesseeInfoMutationMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutationPrint _mutationPrint = new MutationPrint();
//			_mutationPrint.setMailingAddressLine1(rs.getString("ASMT_ADRS_1"));
//			_mutationPrint.setMailingAddressLine2(rs.getString("ASMT_ADRS_2"));
//			_mutationPrint.setMailingAddressLine3(rs.getString("ASMT_ADRS_3"));
//			// System.out.println("Addrd 3::::"+_pdDemand.getMailingAddressLine3());
//			_mutationPrint.setMailingAddressLine4(rs.getString("ASMT_ADRS_4"));
//			_mutationPrint.setMailingAddressLine5(rs.getString("ASMT_ADRS_5"));
//			_mutationPrint.setMailingAddressLine6(rs.getString("ASMT_ADRS_6"));
//			_mutationPrint.setMailingAddressLine7(rs.getString("ASMT_ADRS_7"));
//			_mutationPrint.setMailingAddressLine8(rs.getString("ASMT_ADRS_8"));
//			_mutationPrint.setPersonLiable(rs.getString("PERSON_LIABLE"));
//			_mutationPrint.setMailingPinCode(rs.getString("ASMT_PIN_CODE"));
//			_mutationPrint.setWardNo(rs.getString("ASMT_WARD_NO"));
//			_mutationPrint.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			_mutationPrint.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			_mutationPrint.setStreetName(rs.getString("COM_STREET_NAME"));
//			_mutationPrint.setOwnerName1(rs.getString("OWNER"));
//			_mutationPrint.setOwnerName2(rs.getString("ASMT_OWN_2"));
//			_mutationPrint.setOwnerName3(rs.getString("ASMT_OWN_3"));
//			_mutationPrint.setOwnerName4(rs.getString("ASMT_OWN_4"));
//			_mutationPrint.setOwnerName5(rs.getString("ASMT_OWN_5"));
//			_mutationPrint.setOwnerName6(rs.getString("ASMT_OWN_6"));
//			_mutationPrint.setOwnerName7(rs.getString("ASMT_OWN_7"));
//			_mutationPrint.setOwnerName8(rs.getString("ASMT_OWN_8"));
//			_mutationPrint.setOwnerName9(rs.getString("ASMT_OWN_9"));
//			_mutationPrint.setOwnerName10(rs.getString("ASMT_OWN_10"));
//
//			return _mutationPrint;
//		}
//	}
//
//	////// ****** GET ASSESSEE INFORMATION FOR
//	////// MUTATION***********************////////////
//
//	public KMCPortalServiceReturnObject getAssesseeInfoForMutation(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		String sqlQuery = KMCAssessmentConstants.GET_ASSESSEE_INFO();
//		// System.out.println("sqlQuery:::::::::::::::::::::::::::::::"+sqlQuery);
//		AssesseeInfoMutationMapper _assesseeInfoMapper = new AssesseeInfoMutationMapper();
//		MutationPrint _mutationPrint = new MutationPrint();
//		_mutationPrint = (MutationPrint) jdbcTemplate.queryForObject(sqlQuery, new Object[] { _assesseeNo, wardNo },
//				_assesseeInfoMapper);
//
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.PrintAppConstants.MUTATION, _mutationPrint);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//
//		return _portalServiceReturnObject;
//	}
//
//	///////////////// Getting Barcode Details For
//	///////////////// Mutation//////////////////////////////////
//
//	private static final class DuplicateMutationBarcodeMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			MutationBarcodeDetails _mutationBarcodeDetails = new MutationBarcodeDetails();
//			// _mutationBarcodeDetails.setQuarterNo(rs.getString("BILLED_QTR"));
//			_mutationBarcodeDetails.setBarcode(rs.getString("BARCODE"));
//			return _mutationBarcodeDetails;
//		}
//	}
//
//	public HashMap getBarcodeDetailsForMutationPrint(HashMap infoMap) throws KMCPortalBusinessException {
//		// KMCPortalServiceReturnObject _portalServiceReturnObject = new
//		// KMCPortalServiceReturnObject();
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		System.out.println("_assesseeNo:::::::::" + _assesseeNo);
//		System.out.println("wardNo:::::::::::" + wardNo);
//		String billedYear = null;
//
//		billedYear = KMCAssessmentUtility.getCurrentFinYear();
//		billedYear = billedYear.substring(0, 4);
//		System.out.println("billedYear::::::::::::::::::::::::" + billedYear);
//		// String sqlQuery =
//		// KMCAssessmentConstants.GET_DUPLICATE_PD_BARCODE_DTLS();//commented on 29-3-12
//		// to change pd barcode
//		String sqlQuery = KMCAssessmentConstants.GET_MUTATION_BARCODE();
//		System.out.println("sqlQuery::::::::::::::" + sqlQuery);
//		DuplicateMutationBarcodeMapper _duplicateMutationBarcodeMapper = new DuplicateMutationBarcodeMapper();
//		List mutBarcodeList = new ArrayList();
//		mutBarcodeList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _caseNo },
//				_duplicateMutationBarcodeMapper);
//
//		returnMap.put("mutBarcodeList", mutBarcodeList);
//
//		return returnMap;
//	}
//
//	/************************
//	 * Added By Ananya For Mutation Print ends
//	 ************************************************/
//
//	// Added By Ananya for Mutation Bill Print
//	/*****************
//	 * Added By Ananya for Mutation Bill Print
//	 ************************************/
//
//	public KMCPortalServiceReturnObject getDetailsForMutationPrint(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		List retList = new ArrayList();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String caseNo = (String) infoMap.get("CASENO");
//		String loginId = (String) infoMap.get("LOGINID");
//		String paramCert = (String) infoMap.get("MUTACERTFEES");
//		if (caseNo == null || caseNo.equals("")) {
//			String sqlQuery = KMCAssessmentConstants.getMutationPrintForAssess();
//			System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//			AssessmentMutationPrintRowMapper _outRowmapper = new AssessmentMutationPrintRowMapper();
//			// List retList =new ArrayList();
//			retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, loginId }, _outRowmapper);
//		} else {
//			String sqlQuery = "";
//			AssessmentMutationPrintRowMapper _outRowmapper = new AssessmentMutationPrintRowMapper();
//			if (paramCert.equals("mutaCetificatefees")) {
//				sqlQuery = KMCAssessmentConstants.getMutationCertificateAndProcessFees();
//				retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, caseNo }, _outRowmapper);
//			} else {
//				sqlQuery = KMCAssessmentConstants.getMutationPaymentForAssess();
//				retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, caseNo, loginId }, _outRowmapper);
//			}
//			System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//
//			// String todate = UtilityForAll.getTodaysDate();
//			// String year = KMCAssessmentUtility.getCurrentFinYear();
//
//			System.out.println(retList);
//		}
//		// jdbcTemplate.
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid Mutation Fees exist for the given assessee for current year");
//			throw _busException;
//		}
//
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	/*****************
//	 * Added By Ananya for Mutation Bill Print
//	 ************************************/
//
//	/****************
//	 * Added By Ananya For Muta_Status_Search Page Starts
//	 **************/
//
//	public KMCPortalServiceReturnObject searchDetailsForMutaStatusinDao(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String caseNo = (String) infoMap.get("CASENO");
//		String fromDate = (String) infoMap.get("FROM_DATE");
//		String toDate = (String) infoMap.get("TO_DATE");
//		String loginId = (String) infoMap.get("LOGINID");
//		String indFlag = (String) infoMap.get("INDFLAG");
//		List retList = new ArrayList();
//		List retList2 = new ArrayList();
//		List finalList = new ArrayList();
//		MutaStatusDTO mutaobj = null;
//		MutaStatusDTO mutaobject = null;
//
//		String hearindDate = null;
//		String hearindTime = null;
//		String verOfficer = null;
//		String remarks = null;
//
//		MutaStatusDTO mutaStatusDTOobj = new MutaStatusDTO();
//		HashMap returnMap = new HashMap();
//		// vTask != null && vTask.length()
//
//		if ((_assesseeNo.length() > 0) && (caseNo.length() > 0) && (fromDate.length() > 0) && (toDate.length() > 0)) {
//			String sqlQuery = KMCAssessmentConstants.GET_MUTA_SEARCH_STATUS3();
//			System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//			AssessmentMutaStatusSearchRowMapper _outRowmapper = new AssessmentMutaStatusSearchRowMapper();
//			// List retList =new ArrayList();
//			// String todate = UtilityForAll.getTodaysDate();
//			// String year = KMCAssessmentUtility.getCurrentFinYear();
//			retList = jdbcTemplate.query(sqlQuery,
//					new Object[] { _assesseeNo, caseNo, fromDate, toDate, loginId, indFlag }, _outRowmapper);
//			if (retList == null || retList.size() == 0) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("No data exist  ");
//				throw _busException;
//			}
//
//			System.out.println(retList);
//
//			if (retList.size() > 0) {
//				for (int i = 0; i < retList.size(); i++) {
//					mutaobj = (MutaStatusDTO) retList.get(i);
//					String caseNum = mutaobj.getCaseNo();
//					String sqlQuery2 = KMCAssessmentConstants.GET_MUTA_SEARCH_HEARINGDT_N_TIME();
//					System.out.println("sqlQuery2::::::::::::::::" + sqlQuery2);
//
//					Connection conn = null;
//					PreparedStatement ps = null;
//
//					ResultSet rs = null;
//					String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//					try {
//						conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//						ps = conn.prepareStatement(sqlQuery2);
//						ps.setString(1, _assesseeNo);
//						ps.setString(2, caseNum);
//						ps.setString(3, _assesseeNo);
//						ps.setString(4, caseNum);
//
//						rs = ps.executeQuery();
//						while (rs.next()) {
//							hearindDate = rs.getString("ASMT_HEARING_DATE");
//							hearindTime = rs.getString("ASMT_HEARING_TIME");
//							verOfficer = rs.getString("ASMT_VER_OFFICER_NAME");
//							remarks = rs.getString("REMARKS");
//
//						}
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					} finally {
//						try {
//							if (ps != null)
//								ps.close();
//							if (conn != null)
//								conn.close();
//						} catch (Exception e) {
//						}
//					}
//
//					if (retList.size() > 0) {
//						mutaStatusDTOobj = (MutaStatusDTO) retList.get(i);
//						mutaStatusDTOobj.setHearingDate(hearindDate);
//						mutaStatusDTOobj.setHearingTime(hearindTime);
//						mutaStatusDTOobj.setAsmtVerOfficerName(verOfficer);
//						mutaStatusDTOobj.setRemarks(remarks);
//
//					}
//
//				}
//			}
//
//		} else if ((_assesseeNo.length() > 0) && (caseNo.length() > 0)) {
//			String sqlQuery = KMCAssessmentConstants.GET_MUTA_SEARCH_STATUS1();
//			System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//			AssessmentMutaStatusSearchRowMapper _outRowmapper = new AssessmentMutaStatusSearchRowMapper();
//			// List retList =new ArrayList();
//			// String todate = UtilityForAll.getTodaysDate();
//			// String year = KMCAssessmentUtility.getCurrentFinYear();
//			retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, caseNo, loginId, indFlag },
//					_outRowmapper);
//			if (retList == null || retList.size() == 0) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("No data exist  ");
//				throw _busException;
//			}
//
//			System.out.println(retList);
//			if (retList.size() > 0) {
//				for (int i = 0; i < retList.size(); i++) {
//					mutaobj = (MutaStatusDTO) retList.get(i);
//					String caseNum = mutaobj.getCaseNo();
//					String sqlQuery2 = KMCAssessmentConstants.GET_MUTA_SEARCH_HEARINGDT_N_TIME();
//					System.out.println("sqlQuery2::::::::::::::::" + sqlQuery2);
//
//					Connection conn = null;
//					PreparedStatement ps = null;
//
//					ResultSet rs = null;
//					String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//					try {
//						conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//						ps = conn.prepareStatement(sqlQuery2);
//						ps.setString(1, _assesseeNo);
//						ps.setString(2, caseNum);
//						ps.setString(3, _assesseeNo);
//						ps.setString(4, caseNum);
//
//						rs = ps.executeQuery();
//						while (rs.next()) {
//							hearindDate = rs.getString("ASMT_HEARING_DATE");
//							hearindTime = rs.getString("ASMT_HEARING_TIME");
//							verOfficer = rs.getString("ASMT_VER_OFFICER_NAME");
//							remarks = rs.getString("REMARKS");
//
//						}
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					} finally {
//						try {
//							if (ps != null)
//								ps.close();
//							if (conn != null)
//								conn.close();
//						} catch (Exception e) {
//						}
//					}
//
//					if (retList.size() > 0) {
//						mutaStatusDTOobj = (MutaStatusDTO) retList.get(i);
//						mutaStatusDTOobj.setHearingDate(hearindDate);
//						mutaStatusDTOobj.setHearingTime(hearindTime);
//						mutaStatusDTOobj.setAsmtVerOfficerName(verOfficer);
//						mutaStatusDTOobj.setRemarks(remarks);
//
//					}
//
//				}
//			}
//		}
//
//		else if ((_assesseeNo.length() > 0) && (fromDate.length() > 0) && (toDate.length() > 0)) {
//			String sqlQuery = KMCAssessmentConstants.GET_MUTA_SEARCH_STATUS2();
//			System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//			AssessmentMutaStatusSearchRowMapper _outRowmapper = new AssessmentMutaStatusSearchRowMapper();
//			// List retList =new ArrayList();
//			// String todate = UtilityForAll.getTodaysDate();
//			// String year = KMCAssessmentUtility.getCurrentFinYear();
//			retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, fromDate, toDate, loginId, indFlag },
//					_outRowmapper);
//			if (retList == null || retList.size() == 0) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("No data exist  ");
//				throw _busException;
//			}
//			System.out.println(retList);
//			if (retList.size() > 0) {
//				for (int i = 0; i < retList.size(); i++) {
//
//					mutaobj = (MutaStatusDTO) retList.get(i);
//					String caseNum = mutaobj.getCaseNo();
//					String sqlQuery2 = KMCAssessmentConstants.GET_MUTA_SEARCH_HEARINGDT_N_TIME();
//					System.out.println("sqlQuery2::::::::::::::::" + sqlQuery2);
//
//					Connection conn = null;
//					PreparedStatement ps = null;
//
//					ResultSet rs = null;
//					String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//					try {
//						conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//						ps = conn.prepareStatement(sqlQuery2);
//						ps.setString(1, _assesseeNo);
//						ps.setString(2, caseNum);
//						ps.setString(3, _assesseeNo);
//						ps.setString(4, caseNum);
//
//						rs = ps.executeQuery();
//						while (rs.next()) {
//							hearindDate = rs.getString("ASMT_HEARING_DATE");
//							hearindTime = rs.getString("ASMT_HEARING_TIME");
//							verOfficer = rs.getString("ASMT_VER_OFFICER_NAME");
//							remarks = rs.getString("REMARKS");
//
//						}
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					} finally {
//						try {
//							if (ps != null)
//								ps.close();
//							if (conn != null)
//								conn.close();
//						} catch (Exception e) {
//						}
//					}
//
//					if (retList.size() > 0) {
//						mutaStatusDTOobj = (MutaStatusDTO) retList.get(i);
//						mutaStatusDTOobj.setHearingDate(hearindDate);
//						mutaStatusDTOobj.setHearingTime(hearindTime);
//						mutaStatusDTOobj.setAsmtVerOfficerName(verOfficer);
//						mutaStatusDTOobj.setRemarks(remarks);
//
//					}
//
//				}
//			}
//		}
//
//		else if ((_assesseeNo.length() > 0)) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(
//					"Please provide the either combination -- (assessee no and case no) or (assessee no and from_Date To_Date) along with Assessee no ");
//			throw _busException;
//		} else if ((caseNo.length() > 0)) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg(
//					"Please provide the either combination -- (assessee no and case no) or (assessee no , case no and from_Date To_Date) along with Assessee no) ");
//			throw _busException;
//		} else if ((fromDate.length() > 0)) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Please provide ToDate along with Fromdate) ");
//			throw _busException;
//		} else if ((toDate.length() > 0)) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Please provide FromDate along with ToDate) ");
//			throw _busException;
//		} else {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("Please provide Valid Combination) ");
//			throw _busException;
//
//		}
//
//		// if(_assesseeNo!=null && caseNo!=null && fromDate!=null && toDate!=null)
//
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No data exist for the given assessee ");
//			throw _busException;
//		}
//
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	/****************
//	 * Added By Ananya For Muta_Status_Search Page Ends
//	 **************/
//
//	/*****************
//	 * Added By Ananya Starts for Muta Status Search in dao
//	 ***************/
//
//	public KMCPortalServiceReturnObject printMutaStatInfoInDao(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into printMutaStatInfoInDao of DAO");
//		}
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//		// String wardNo = _assesseeNo.substring(2,5);
//
//		String sqlQuery = KMCAssessmentConstants.GET_MORE_ASSESSEE_INFO();
//		System.out.println("In sqlQuery  in DAO sql= " + sqlQuery);
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _caseNo }, new MutaStatInfoMapper());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid Mutation fees exist for the given assessee for current year");
//			// throw _busException;
//		}
//
//		System.out.println("retList.size()=" + retList.size());
//		MutaStatDto mutaStatDto = new MutaStatDto();
//
//		if (retList.size() > 0) {
//			mutaStatDto = (MutaStatDto) retList.get(0);
//		}
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PrintMutaStatInfo", mutaStatDto);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject printMutaStatExtraInfoInDao(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into printMutaStatExtraInfoInDao of DAO");
//		}
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//		// String wardNo = _assesseeNo.substring(2,5);
//
//		String sqlQuery = KMCAssessmentConstants.GET_WARD_AND_PREMISE_INFO();
//		System.out.println("In sqlQuery  in DAO sql= " + sqlQuery);
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, new MutaStatExtraInfoMapper());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid Mutation fees exist for the given assessee for current year");
//			// throw _busException;
//		}
//
//		System.out.println("retList.size()=" + retList.size());
//		MutaStatDto mutaStatDto = new MutaStatDto();
//
//		if (retList.size() > 0) {
//			mutaStatDto = (MutaStatDto) retList.get(0);
//		}
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PrintMutaStatExtraInfo", mutaStatDto);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject printMiscSuspPayeeInfo(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into printMutaStatExtraInfoInDao of DAO");
//		}
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//
//		String transactionID = (String) infoMap.get("TXN_ID");
//		// String wardNo = _assesseeNo.substring(2,5);
//
//		String sqlQuery = KMCAssessmentConstants.GET_WARD_AND_PREMISE_MISC_SUSP_INFO();
//		System.out.println("In sqlQuery  in DAO sql= " + sqlQuery);
//		List retList = new ArrayList();
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { transactionID }, new MiscSuspExtraInfoMapper());
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No unpaid Mutation fees exist for the given assessee for current year");
//			// throw _busException;
//		}
//
//		System.out.println("retList.size()=" + retList.size());
//		MutaStatDto mutaStatDto = new MutaStatDto();
//
//		if (retList.size() > 0) {
//			mutaStatDto = (MutaStatDto) retList.get(0);
//		}
//
//		HashMap returnMap = new HashMap();
//		returnMap.put("PrintMutaStatExtraInfo", mutaStatDto);
//
//		_obj.setReturnMap(returnMap);
//
//		return _obj;
//	}
//
//	public KMCPortalServiceReturnObject getTenantDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String caseNo = (String) infoMap.get("CASENO");
//		String sqlQuery = KMCAssessmentConstants.getTenantDetails();
//		System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//		AssessmentTenantRowMapper _outRowmapper = new AssessmentTenantRowMapper();
//		List retList = new ArrayList();
//
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { caseNo }, _outRowmapper);
//
//		System.out.println(retList);
//		// jdbcTemplate.
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No tenant details exist for the given assessee");
//			// throw _busException;
//		}
//
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public KMCPortalServiceReturnObject getApplicationDesc(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String caseNo = (String) infoMap.get("CASENO");
//		String sqlQuery = KMCAssessmentConstants.GET_MUTA_APPLICATION_DESC();
//		System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//		AssessmentApplicationDescRowMapper _outRowmapper = new AssessmentApplicationDescRowMapper();
//		List retList = new ArrayList();
//
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { caseNo }, _outRowmapper);
//
//		System.out.println(retList);
//		// jdbcTemplate.
//
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No Application Desc exist for the given assessee");
//			// throw _busException;
//		}
//
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public KMCPortalServiceReturnObject getSurchargeDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String caseNo = (String) infoMap.get("CASENO");
//		String sqlQuery = KMCAssessmentConstants.GET_MUTA_SURCHARGE_DETAILS();
//		System.out.println("sqlQuery::::::::::::::::" + sqlQuery);
//		AssessmentSurchargeDetailsRowMapper _outRowmapper = new AssessmentSurchargeDetailsRowMapper();
//		List retList = new ArrayList();
//
//		retList = jdbcTemplate.query(sqlQuery, new Object[] { caseNo }, _outRowmapper);
//
//		System.out.println(retList);
//		// jdbcTemplate.
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No surcharge details exist for the given assessee");
//			// throw _busException;
//		}
//
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public HashMap getBarcodeDetailsForMutaStat(HashMap infoMap) throws KMCPortalBusinessException {
//		// KMCPortalServiceReturnObject _portalServiceReturnObject = new
//		// KMCPortalServiceReturnObject();
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _caseNo = (String) infoMap.get("CASENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		System.out.println("_assesseeNo:::::::::" + _assesseeNo);
//		System.out.println("wardNo:::::::::::" + wardNo);
//		String billedYear = null;
//
//		billedYear = KMCAssessmentUtility.getCurrentFinYear();
//		billedYear = billedYear.substring(0, 4);
//		System.out.println("billedYear::::::::::::::::::::::::" + billedYear);
//		// String sqlQuery =
//		// KMCAssessmentConstants.GET_DUPLICATE_PD_BARCODE_DTLS();//commented on 29-3-12
//		// to change pd barcode
//		String sqlQuery = KMCAssessmentConstants.GET_MUTA_STAT_BARCODE();
//		System.out.println("sqlQuery::::::::::::::" + sqlQuery);
//		MutaStatBarcodeMapper _mutaStatBarcodeMapper = new MutaStatBarcodeMapper();
//		List mutBarcodeList = new ArrayList();
//		mutBarcodeList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, _caseNo },
//				_mutaStatBarcodeMapper);
//
//		returnMap.put("mutaStatBarcodeList", mutBarcodeList);
//
//		return returnMap;
//	}
//
//	/*************** Mapper **********************/
//
//	private static final class MutaStatBarcodeMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutaStatBarcodeDetails _mutaStatBarcodeDetails = new MutaStatBarcodeDetails();
//			_mutaStatBarcodeDetails.setBarcode(rs.getString("BARCODE"));
//
//			return _mutaStatBarcodeDetails;
//		}
//	}
//
//	private static final class MutaStatInfoMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutaStatDto _mutaStatDto = new MutaStatDto();
//			_mutaStatDto.setAsmtCaseNumber(rs.getString("ASMT_CASE_NO"));
//			_mutaStatDto.setAsmtAssno(rs.getString("ASMT_ASSNO"));
//			_mutaStatDto.setOldOwner(rs.getString("OLD_OWNER"));
//			_mutaStatDto.setNewOwner(rs.getString("NEW_OWNER"));
//			_mutaStatDto.setOldAddress(rs.getString("OLD_ADDRESS"));
//			_mutaStatDto.setNewAddress(rs.getString("NEW_ADDRESS"));
//			_mutaStatDto.setAsmtDemandId(rs.getString("ASMT_DEMAND_ID"));
//			_mutaStatDto.setDmdStatus(rs.getString("DMD_STATUS"));
//			_mutaStatDto.setTotAmount(rs.getString("TOT_AMOUNT"));
//			_mutaStatDto.setAsmtRcptDate(rs.getString("ASMT_RCPT_DATE"));
//			_mutaStatDto.setAnnualVal(rs.getString("ANNUAL_VAL"));
//			_mutaStatDto.setDateValuation(rs.getString("DATE_VALUATION"));
//			_mutaStatDto.setDateTransProp(rs.getString("DATE_TRANS_PROP"));
//			_mutaStatDto.setStoriesNo(rs.getString("STORIES_NO"));
//			_mutaStatDto.setFlatFloorNo(rs.getString("FLAT_FLOOR_NO"));
//			_mutaStatDto.setVacandLand(rs.getString("VACAND_LAND"));
//			_mutaStatDto.setPondArea(rs.getString("POND_AREA"));
//			_mutaStatDto.setBuildingArea(rs.getString("BUILDING_AREA"));
//			_mutaStatDto.setTotPremisesArea(rs.getString("TOT_PREMISES_AREA"));
//			_mutaStatDto.setCarpetArea(rs.getString("CARPET_AREA"));
//			_mutaStatDto.setClosedGarageArea(rs.getString("CLOSED_GARAGE_AREA"));
//			_mutaStatDto.setOpenGarageArea(rs.getString("OPEN_GARAGE_AREA"));
//			_mutaStatDto.setGardenArea(rs.getString("GARDEN_AREA"));
//			_mutaStatDto.setTotShopNo(rs.getString("TOT_SHOP_NO"));
//			_mutaStatDto.setTotShopArea(rs.getString("TOT_SHOP_AREA"));
//			_mutaStatDto.setTotAtmNo(rs.getString("TOT_ATM_NO"));
//			_mutaStatDto.setTotAtmArea(rs.getString("TOT_ATM_AREA"));
//			_mutaStatDto.setTotNursingNo(rs.getString("TOT_NURSING_NO"));
//			_mutaStatDto.setTotNursingArea(rs.getString("TOT_NURSING_AREA"));
//			_mutaStatDto.setOthersNo(rs.getString("OTHERS_NO"));
//			_mutaStatDto.setOthersArea(rs.getString("OTHERS_AREA"));
//
//			return _mutaStatDto;
//		}
//	}
//
//	private static final class MutaStatExtraInfoMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutaStatDto _mutaStatDto = new MutaStatDto();
//			_mutaStatDto.setWardNo(rs.getString("ASMT_WARD_NO"));
//			_mutaStatDto.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			_mutaStatDto.setStreetName(rs.getString("COM_STREET_NAME"));
//
//			return _mutaStatDto;
//		}
//	}
//
//	private static final class MiscSuspExtraInfoMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutaStatDto _mutaStatDto = new MutaStatDto();
//			_mutaStatDto.setWardNo(rs.getString("ASMT_WARD_NO"));
//			_mutaStatDto.setPremisesNo(rs.getString("ASMT_PREM_NO"));
//			_mutaStatDto.setStreetName(rs.getString("COM_STREET_NAME"));
//			_mutaStatDto.setStreetName(rs.getString("COM_STREET_NAME"));
//			_mutaStatDto.setPersonLiable(rs.getString("asmt_person_liable"));
//
//			return _mutaStatDto;
//		}
//	}
//
//	private static final class AssessmentTenantRowMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			TenantDetails _tenantDetails = new TenantDetails();
//			_tenantDetails.setTentName(rs.getString("TENT_NAME"));
//			_tenantDetails.setTentDetails(rs.getString("TENT_DETAILS"));
//			_tenantDetails.setRentMonth(rs.getString("RENT_MONTH"));
//			_tenantDetails.setUseNature(rs.getString("USE_NATURE"));
//
//			return _tenantDetails;
//		}
//	}
//
//	private static final class AssessmentSurchargeDetailsRowMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			SurchargeDetails _surchargeDetails = new SurchargeDetails();
//			_surchargeDetails.setDetailsOfPremises(rs.getString("DETAILS_OF_PREMISES"));
//
//			return _surchargeDetails;
//		}
//	}
//
//	private static final class AssessmentApplicationDescRowMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			ApplicationDescDetails _applicationDescDetails = new ApplicationDescDetails();
//			_applicationDescDetails.setAppDesc(rs.getString("APP_DESC"));
//
//			return _applicationDescDetails;
//		}
//	}
//
//	public KMCPortalServiceReturnObject searchForMutationReceipt(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering searchForMutationReceiptt");
//		}
//		String assesseeNo = (String) infoMap.get("ASSESSENO");
//		String fromDate = (String) infoMap.get("FROM_DATE");
//		String toDate = (String) infoMap.get("TO_DATE");
//		String loginId = (String) infoMap.get("LOGINID");
//		System.out.println("toDate::::::::::::" + toDate);
//
//		List txnDetailList = new ArrayList();
//		String sql = KMCAssessmentConstants.RECEIPT_DETAILS_FOR_GRID();
//
//		String getReceiptNoSQL = KMCAssessmentConstants.GET_RCPT_NO_WITH_ASSNO_FOR_EMUTATIOM();
//		// System.out.println(getReceiptNoSQL);
//		// Log in Id Off on 08/02/2020
//		// List receiptList = jdbcTemplate.query(getReceiptNoSQL,new
//		// Object[]{assesseeNo,fromDate,toDate,loginId},new ReceiptMutationMapper());
//		List receiptList = jdbcTemplate.query(getReceiptNoSQL, new Object[] { assesseeNo, fromDate, toDate },
//				new ReceiptMutationMapper());
//		HashMap returnMap = new HashMap();
//		ReceiptDTO _receiptDTO = null;
//		ArrayList rcptList = new ArrayList();
//
//		for (int i = 0; i < receiptList.size(); i++) {
//			_receiptDTO = (ReceiptDTO) receiptList.get(i);
//			///// TAKING FROM PORTAL_PAY Schema (jdbcTemplatePay)
//			///// ////////////////////////////////
//			txnDetailList = jdbcTemplatePay.query(sql, new Object[] { fromDate, toDate, _receiptDTO.getReceiptNo() },
//					new DuplicateReceiptMutationMapper());
//			rcptList.addAll(txnDetailList);
//
//		}
//		// System.out.println("rcptList"+rcptList.size());
//		returnMap.put("TXN_MUTA_RCPT_SEARCH_DTLS", rcptList);
//		sql = null;// ModifiedSql=null;
//
//		_obj.setReturnMap(returnMap);
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving into getDoc of searchDetailsForPDReceipt");
//		}
//
//		return _obj;
//
//	}
//
//	public KMCPortalServiceReturnObject searchForMiscSuspReceipt(HashMap infoMap) throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering searchForMiscSuspReceipt");
//		}
//		// String assesseeNo = (String)infoMap.get("ASSESSENO");
//		String demandNo = (String) infoMap.get("DEMANDNO");
//		String fromDate = (String) infoMap.get("FROM_DATE");
//		String toDate = (String) infoMap.get("TO_DATE");
//
//		System.out.println("********************demandNo=" + demandNo);
//		System.out.println("********************fromDate=" + fromDate);
//		System.out.println("********************toDate=" + toDate);
//
//		List txnDetailList = new ArrayList();
//		String sql = KMCAssessmentConstants.RECEIPT_DETAILS_FOR_MISC_SUSP();
//
//		String getReceiptNoSQL = KMCAssessmentConstants.GET_RCPT_NO_FOR_MISC_SUSPENSE();
//		List receiptList = jdbcTemplate.query(getReceiptNoSQL, new Object[] { demandNo, fromDate, toDate },
//				new ReceipMiscSuspMapper());
//		HashMap returnMap = new HashMap();
//		ReceiptDTO _receiptDTO = null;
//		ArrayList rcptList = new ArrayList();
//		System.out.println("receiptList=" + receiptList.size());
//		for (int i = 0; i < receiptList.size(); i++) {
//			_receiptDTO = (ReceiptDTO) receiptList.get(i);
//
//			txnDetailList = jdbcTemplatePay.query(sql, new Object[] { fromDate, toDate, _receiptDTO.getReceiptNo() },
//					new DuplicateReceiptMutationMapper());
//			System.out.println("txnDetailList=" + txnDetailList.size());
//			rcptList.addAll(txnDetailList);
//
//		}
//		// System.out.println("rcptList"+rcptList.size());
//		returnMap.put("MISC_SUSP_RCPT_SEARCH_DTLS", rcptList);
//		sql = null;
//
//		_obj.setReturnMap(returnMap);
//
//		if (log.isDebugEnabled()) {
//			log.debug("Leaving of searchForMiscSuspReceipt");
//		}
//
//		return _obj;
//
//	}
//
//	private static final class DuplicateReceiptMutationMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			MutationReceiptDTO mutationReceiptDTO = (MutationReceiptDTO) DTOFactory
//					.createDTO("com.kmc.portal.dto.business.MutationReceiptDTO");
//
//			mutationReceiptDTO.setTxnID(rs.getString("TXN_ID"));
//			mutationReceiptDTO.setTxnType(rs.getString("TXN_TYPE"));
//			mutationReceiptDTO.setTxnAmount(rs.getString("TXN_AMOUNT"));
//			mutationReceiptDTO.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			mutationReceiptDTO.setReceiptDate(rs.getString("RECEIPT_DATE"));
//			mutationReceiptDTO.setTxnPayModeDesc(rs.getString("PAY_MODE_DESC"));
//			mutationReceiptDTO.setTxnPayModeShortDesc(rs.getString("PAY_MODE_SHORT_DESC"));
//			return mutationReceiptDTO;
//
//		}// end of method
//
//	}
//
//	private static final class ReceiptMutationMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			ReceiptDTO _receiptDTO = (ReceiptDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.ReceiptDTO");
//			_receiptDTO.setReceiptNo(rs.getString("ASMT_RECEIPT_NO"));
//			return _receiptDTO;
//
//		}// end of method
//
//	}
//
//	private static final class ReceipMiscSuspMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			ReceiptDTO _receiptDTO = (ReceiptDTO) DTOFactory.createDTO("com.kmc.portal.dto.business.ReceiptDTO");
//			_receiptDTO.setReceiptNo(rs.getString("RECEIPT_NO"));
//			return _receiptDTO;
//
//		}// end of method
//
//	}
//
//	/*****************
//	 * For E-Mutation Receipt print
//	 ******************************************************/
//	private static final class EMutationReceipTxnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the txn details Details for Printing /////
//			MutationReceipt mutationReceipt = new MutationReceipt();
//			mutationReceipt.setTotalAmt(rs.getString("TXN_AMOUNT"));
//			mutationReceipt.setReceiptDate(rs.getString("RECEIPT_DATE"));
//			mutationReceipt.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			mutationReceipt.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			mutationReceipt.setAmtInWords(rs.getString("AMT_IN_WORDS"));
//			mutationReceipt.setPaymodeShortDesc(rs.getString("PAY_MODE_SHORT_DESC"));
//			mutationReceipt.setPaymodeDesc(rs.getString("PAY_MODE_DESC"));
//			return mutationReceipt;
//		}
//	}
//
//	/*****************
//	 * For Misc Suspense Receipt print
//	 ******************************************************/
//	private static final class MiscSuspenseReceipTxnMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the txn details Details for Printing /////
//			MutationReceipt mutationReceipt = new MutationReceipt();
//			mutationReceipt.setTotalAmt(rs.getString("TXN_AMOUNT"));
//			mutationReceipt.setReceiptDate(rs.getString("RECEIPT_DATE"));
//			mutationReceipt.setReceiptNo(rs.getString("TXN_RECPT_NO"));
//			mutationReceipt.setAssesseeNo(rs.getString("ASMT_ASSNO"));
//			mutationReceipt.setAmtInWords(rs.getString("AMT_IN_WORDS"));
//			mutationReceipt.setPaymodeShortDesc(rs.getString("PAY_MODE_SHORT_DESC"));
//			mutationReceipt.setPaymodeDesc(rs.getString("PAY_MODE_DESC"));
//			return mutationReceipt;
//		}
//	}
//
//	public HashMap getReceiptTxnDetailsForEMutation(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap passedMap = new HashMap();
//		String transactionID = (String) infoMap.get("TXN_ID");
//		String sqlQuery = KMCAssessmentConstants.GET_TXN_DETAILS_FOR_EMUTATION();
//		// System.out.println(sqlQuery);
//		EMutationReceipTxnMapper eMutationReceipTxnMapper = new EMutationReceipTxnMapper();
//		MutationReceipt _mutationReceipt = (MutationReceipt) jdbcTemplatePay.queryForObject(sqlQuery,
//				new Object[] { transactionID }, eMutationReceipTxnMapper);
//		_mutationReceipt.setTxnId(transactionID);
//		passedMap.put(KMCAssessmentConstants.PrintAppConstants.EMUTATION_RECEIPT, _mutationReceipt);
//		return passedMap;
//
//	}
//
//	public HashMap getReceiptTxnDetailsForMiscSusp(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap passedMap = new HashMap();
//		String transactionID = (String) infoMap.get("TXN_ID");
//		String sqlQuery = KMCAssessmentConstants.GET_TXN_DETAILS_FOR_MISC_SUSP();
//		// System.out.println(sqlQuery);
//		MiscSuspenseReceipTxnMapper miscSuspenseReceipTxnMapper = new MiscSuspenseReceipTxnMapper();
//		MutationReceipt _mutationReceipt = (MutationReceipt) jdbcTemplatePay.queryForObject(sqlQuery,
//				new Object[] { transactionID }, miscSuspenseReceipTxnMapper);
//		_mutationReceipt.setTxnId(transactionID);
//		passedMap.put(KMCAssessmentConstants.PrintAppConstants.EMUTATION_RECEIPT, _mutationReceipt);
//		return passedMap;
//
//	}
//
//	// assesse info in print Mutation receipt
//	public KMCPortalServiceReturnObject printMutationReceiptAssesseInfo(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into printMutationReceiptAssesseInfo of DAO");
//		}
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String transactionID = (String) infoMap.get("TXN_ID");
//		System.out.println("transactionID:::::::::::::::::::::::::::::::" + transactionID);
//		String wardNo = _assesseeNo.substring(2, 5);
//		String sqlQuery = KMCAssessmentConstants.GET_MORE_ASSESSEE_INFO_EMUTATION_RECEIPT();// for receipt mutation
//																							// assess details
//		System.out.println("sqlQuery:::::::::::::::::::::::::::::::" + sqlQuery);
//		AssesseeMoreInfoMutatnReceiptMapper aseeMoreInfoMutatnReceiptMapper = new AssesseeMoreInfoMutatnReceiptMapper();
//		MutationReceipts mmutationReceipts = new MutationReceipts();
//		mmutationReceipts = (MutationReceipts) jdbcTemplate.queryForObject(sqlQuery,
//				new Object[] { _assesseeNo, transactionID }, aseeMoreInfoMutatnReceiptMapper);
//		System.out.println("Change end::::");
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.PrintAppConstants.MUTATIONLISTFORRECEIPT, mmutationReceipts);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//
//		return _portalServiceReturnObject;
//	}
//
//	public KMCPortalServiceReturnObject printMiscSuscReceiptAssesseInfo(HashMap infoMap)
//			throws KMCPortalBusinessException {
//		KMCPortalServiceReturnObject _obj = new KMCPortalServiceReturnObject();
//		if (log.isDebugEnabled()) {
//			log.debug("Entering into printMutationReceiptAssesseInfo of DAO");
//		}
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String transactionID = (String) infoMap.get("TXN_ID");
//		System.out.println("transactionID:::::::::::::::::::::::::::::::" + transactionID);
//		String wardNo = _assesseeNo.substring(2, 5);
//		String sqlQuery = KMCAssessmentConstants.GET_MORE_ASSESSEE_INFO_MISC_SUSP_RECEIPT();
//		System.out.println("sqlQuery:::::::::::::::::::::::::::::::" + sqlQuery);
//		MiscSuspPayeeInfoMapper miscSuspPayeeInfoMapper = new MiscSuspPayeeInfoMapper();
//		MutationReceipts mmutationReceipts = new MutationReceipts();
//		mmutationReceipts = (MutationReceipts) jdbcTemplate.queryForObject(sqlQuery, new Object[] { transactionID },
//				miscSuspPayeeInfoMapper);
//		System.out.println("Change end::::");
//		HashMap returnMap = new HashMap();
//		returnMap.put(KMCAssessmentConstants.PrintAppConstants.MUTATIONLISTFORRECEIPT, mmutationReceipts);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//
//		return _portalServiceReturnObject;
//	}
//
//	private static final class AssesseeMoreInfoMutatnReceiptMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutationReceipts mutationReceipts = new MutationReceipts();
//			mutationReceipts.setAsmtCaseNumber(rs.getString("ASMT_CASE_NO"));
//			mutationReceipts.setAsmtAssno(rs.getString("ASMT_ASSNO"));
//			mutationReceipts.setOldOwner(rs.getString("OLD_OWNER"));
//			mutationReceipts.setNewOwner(rs.getString("NEW_OWNER"));
//			mutationReceipts.setOldAddress(rs.getString("OLD_ADDRESS"));
//			mutationReceipts.setNewAddress(rs.getString("NEW_ADDRESS"));
//			mutationReceipts.setAsmtDemandId(rs.getString("ASMT_DEMAND_ID"));
//			mutationReceipts.setDmdStatus(rs.getString("DMD_STATUS"));
//			mutationReceipts.setTotAmount(rs.getString("TOT_AMOUNT"));
//			mutationReceipts.setAsmtRcptDate(rs.getString("ASMT_RCPT_DATE"));
//
//			return mutationReceipts;
//		}
//	}
//
//	private static final class MiscSuspPayeeInfoMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Details into BuildingHearingCard object for Printing /////
//			MutationReceipts mutationReceipts = new MutationReceipts();
//			mutationReceipts.setAsmtCaseNumber(rs.getString("ASMT_CASE_NO"));
//			mutationReceipts.setAsmtAssno(rs.getString("ASMT_ASSNO"));
//			mutationReceipts.setOldOwner(rs.getString("OLD_OWNER"));
//			mutationReceipts.setNewOwner(rs.getString("NEW_OWNER"));
//			mutationReceipts.setOldAddress(rs.getString("OLD_ADDRESS"));
//			mutationReceipts.setNewAddress(rs.getString("NEW_ADDRESS"));
//			mutationReceipts.setAsmtDemandId(rs.getString("ASMT_DEMAND_ID"));
//			mutationReceipts.setDmdStatus(rs.getString("DMD_STATUS"));
//			mutationReceipts.setTotAmount(rs.getString("TOT_AMOUNT"));
//			mutationReceipts.setAsmtRcptDate(rs.getString("ASMT_RCPT_DATE"));
//
//			mutationReceipts.setApplicantName(rs.getString("applicant_name"));
//			mutationReceipts.setApplicantAddress(rs.getString("address"));
//			mutationReceipts.setApplicantMobileNo(rs.getString("mobile_no"));
//			mutationReceipts.setApplicantEmail(rs.getString("email"));
//			mutationReceipts.setPayType(rs.getString("paymet_type"));
//			mutationReceipts.setPaymodeDesc(rs.getString("payment_desc"));
//			mutationReceipts.setBiCode(rs.getString("bi_code"));
//
//			return mutationReceipts;
//		}
//	}
//
//	public HashMap getReceiptBillDetailsfForEmutation(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String receiptNo = (String) infoMap.get("MUTATION_RECEIPTNO");
//
//		// String receiptNo = "E2" ;
//
//		String sqlQuery = KMCAssessmentConstants.GET_RECEIPT_BILL_DETAILS_FOR_EMUTATION();
//		// System.out.println("sqlQuery::::::::::::::"+sqlQuery);
//		MutationReceiptBillDetailsMapper mutationReceiptBillDetailsMapper = new MutationReceiptBillDetailsMapper();
//		List receiptBillList = new ArrayList();
//		receiptBillList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo, receiptNo },
//				mutationReceiptBillDetailsMapper);
//
//		returnMap.put("receiptBillListForMutation", receiptBillList);
//
//		return returnMap;
//
//	}
//
//	public HashMap getReceiptBillDetailsfForMiscSusp(HashMap infoMap) throws KMCPortalBusinessException {
//
//		HashMap returnMap = new HashMap();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String receiptNo = (String) infoMap.get("MUTATION_RECEIPTNO");
//
//		// String receiptNo = "E2" ;
//
//		String sqlQuery = KMCAssessmentConstants.GET_RECEIPT_BILL_DETAILS_FOR_MISC_SUSP();
//		// System.out.println("sqlQuery::::::::::::::"+sqlQuery);
//		MiscSuspReceiptBillDetailsMapper miscSuspReceiptBillDetailsMapper = new MiscSuspReceiptBillDetailsMapper();
//		List receiptBillList = new ArrayList();
//		receiptBillList = (ArrayList) jdbcTemplate.query(sqlQuery, new Object[] { receiptNo },
//				miscSuspReceiptBillDetailsMapper);
//
//		returnMap.put("receiptBillListForMutation", receiptBillList);
//
//		return returnMap;
//
//	}
//
//	private static final class MutationReceiptBillDetailsMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			MutationReceiptBillDetails mutationReceiptBillDetails = new MutationReceiptBillDetails();
//			mutationReceiptBillDetails.setDemandId(rs.getString("ASMT_DEMAND_ID"));
//			mutationReceiptBillDetails.setStatus(rs.getString("dmd_status"));
//			mutationReceiptBillDetails.setTotAmount(rs.getString("tot_amount"));
//			mutationReceiptBillDetails.setAssNo(rs.getString("asmt_assno"));
//			return mutationReceiptBillDetails;
//		}
//	}
//
//	private static final class MiscSuspReceiptBillDetailsMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			MutationReceiptBillDetails mutationReceiptBillDetails = new MutationReceiptBillDetails();
//			mutationReceiptBillDetails.setDemandId(rs.getString("ASMT_DEMAND_ID"));
//			mutationReceiptBillDetails.setStatus(rs.getString("dmd_status"));
//			mutationReceiptBillDetails.setTotAmount(rs.getString("tot_amount"));
//			mutationReceiptBillDetails.setAssNo(rs.getString("asmt_assno"));
//			return mutationReceiptBillDetails;
//		}
//	}
//
//	private static final class MutationReceiptBarcodeMapper implements RowMapper {
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			//// Putting the Barcode Details into PDDemand object for Printing /////
//			MutationReceiptBarcodeDetails mutationReceiptBarcodeDetails = new MutationReceiptBarcodeDetails();
//			mutationReceiptBarcodeDetails.setMutationReceiptBarcode(rs.getString("RCPT_BARCODE"));
//			return mutationReceiptBarcodeDetails;
//		}
//	}
//
//	/// Start of Code by Debarshi as on 02/03/2010 /////////////////////
//
//	public HashMap getMutationReceiptBarcodeDetails(HashMap infoMap) throws KMCPortalBusinessException {
//		String transactionID = (String) infoMap.get("TXN_ID");
//		MutationReceiptBarcodeDetails mutationRcptBarcode = null;
//		String sql = KMCAssessmentConstants.GET_RECEIPT_BARCODE_DETAILS_FOR_MUTATION();// TO ASK RATUL FOR RECEIPT
//																						// BARCODE
//		mutationRcptBarcode = (MutationReceiptBarcodeDetails) jdbcTemplatePay.queryForObject(sql,
//				new Object[] { transactionID }, new MutationReceiptBarcodeMapper());
//		sql = null;// ModifiedSql=null;
//		HashMap returnMap = new HashMap();
//		returnMap.put("RCPT_MUTATION_BARCODE", mutationRcptBarcode);
//
//		return returnMap;
//
//	}
//
//	public int isWaiverExists(String _assesseeNo, String wardNo, String todate, String year) throws Exception {
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		Connection conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//		PreparedStatement ps = null;
//
//		ResultSet rs = null;
//		int count = 0;
//
//		HashMap receiptSeqGen = new HashMap();
//		try {
//
//			String selectStatement = "SELECT sum (cnt) from( SELECT count (*) cnt FROM ASMT_DEMAND WHERE ASMT_ASSNO = ? AND ASMT_BILL_STATUS = 'B' AND  ASMT_WARD_NO = ? AND ASMT_OUTSTANDING_DATE < TO_DATE(?, 'DD/MM/YYYY') AND ASMT_BILL_TYPE IN ('F', 'S') AND ASMT_OUTSTANDING_DATE <= TO_DATE('31/03/2020', 'DD/MM/YYYY') UNION Select count (*) cnt FROM ASMT_DEMAND  WHERE ASMT_ASSNO = ? AND ASMT_BILL_STATUS = 'B' AND ASMT_WARD_NO = ? AND  SUBSTR(ASMT_BILLED_QTR, 1, 4) < ? AND ASMT_BILL_TYPE = 'P'  AND ASMT_OUTSTANDING_DATE <= TO_DATE('31/03/2020', 'DD/MM/YYYY')) ";
//
//			ps = conn.prepareStatement(selectStatement);
//			ps.setString(1, _assesseeNo);
//			ps.setString(2, wardNo);
//			ps.setString(3, todate);
//			ps.setString(4, _assesseeNo);
//			ps.setString(5, wardNo);
//			ps.setString(6, year);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				count = rs.getInt(1);
//			}
//
//			System.out.println("*************count apllication in isWaiverExists =" + count);
//
//		} finally {
//			if (ps != null)
//				ps.close();
//			if (conn != null)
//				conn.close();
//		}
//		return count;
//	}
//
//	public int isApprovedApplicationExists(String _assesseeNo) throws Exception {
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		Connection conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//		PreparedStatement ps = null;
//
//		ResultSet rs = null;
//		int count = 0;
//
//		HashMap receiptSeqGen = new HashMap();
//		try {
//
//			String selectStatement = "select count(*) from ( Select a.asmt_assno,a.asmt_status_id from asmt_50p_int_waiver a where a.asmt_assno = ? and a.scheme_id = 'W2020') p, (Select max(b.asmt_status_id)asmt_status_id , b.asmt_assno from asmt_50p_int_waiver b where  b.asmt_assno = ?  and b.scheme_id = 'W2020' group by b.asmt_assno) q where p.asmt_assno = q.asmt_assno and q.asmt_status_id=6 and p.asmt_status_id = q.asmt_status_id ";
//
//			ps = conn.prepareStatement(selectStatement);
//			ps.setString(1, _assesseeNo);
//			ps.setString(2, _assesseeNo);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				count = rs.getInt(1);
//			}
//
//			System.out.println("*************count apllication in isApprovedApplicationExists =" + count);
//
//		} finally {
//			if (ps != null)
//				ps.close();
//			if (conn != null)
//				conn.close();
//		}
//		return count;
//	}
//
//	// waiver 2020
//
//	public KMCPortalServiceReturnObject getAssesseeWaiverApplicationDetails(HashMap infoMap)
//			throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//
//		AssesseeWaiverRowMapper _outRowmapper = new AssesseeWaiverRowMapper();
//		AsseRowMapper _asseRowmapper = new AsseRowMapper();
//
//		List retList = new ArrayList();
//		List retAssesseeList = new ArrayList();
//		HashMap returnMap = new HashMap();
//
//		String sqlQuery = " select t.* from asmt_50p_int_waiver t where t.asmt_appln_no like 'WVR2020%' and t.asmt_assno = ? and t.asmt_status_id = '1'";
//
//		String sqlAssesseeQuery = " SELECT A.ASMT_ASSNO, A.ASMT_PREM_NO || ',' || B.COM_STREET_NAME PREMISES, ASMT_OWN_1 || ' ' || ASMT_OWN_2 || ' ' || ASMT_OWN_3 || ' ' || ASMT_OWN_4 || ' ' || ASMT_OWN_5 || ' ' || ASMT_OWN_6 || ' ' || ";
//		sqlAssesseeQuery = sqlAssesseeQuery
//				+ " ASMT_OWN_7 || ' ' || ASMT_OWN_8 || ' ' || ASMT_OWN_9 || ' ' || ASMT_OWN_10 OWNER,  ASMT_ADRS_1 || ' ' || ASMT_ADRS_2 || ' ' || ASMT_ADRS_3 || ' ' || ASMT_ADRS_4 || ' ' || ASMT_ADRS_5 || ' ' || ASMT_ADRS_6 || ' ' ||";
//		sqlAssesseeQuery = sqlAssesseeQuery
//				+ " ASMT_ADRS_7 || ' ' || ASMT_ADRS_8 || ' ' || ASMT_PIN_CODE ADDRESS,  ASMT_CHARACTER_OF_PREMISE, A.ASMT_WARD_NO ward, TRUNC(sysdate) APPLICATIONDATE, '28-02-2020' WAIVERDUEDATE,  TRUNC(sysdate) APPROVEDATE ";
//		sqlAssesseeQuery = sqlAssesseeQuery
//				+ " FROM ASMT_ASSE_MST A, COM_STREET_MST B WHERE A.ASMT_ASSNO = ?   AND B.COM_STREET_CODE = A.ASMT_STREET_CODE  AND B.COM_WARD_NO = A.ASMT_WARD_NO  AND SUBSTR(A.ASMT_ASSNO, 2, 1) NOT IN ('6', '7') AND NVL(A.ASMT_STATUS, ' ') != 'X'";
//
//		System.out.println("sqlAssesseeQuery=" + sqlAssesseeQuery);
//
//		try {
//			retList = jdbcTemplate.query(sqlQuery, new Object[] { _assesseeNo }, _outRowmapper);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		if (retList == null || retList.size() == 0) {
//			retAssesseeList = jdbcTemplate.query(sqlAssesseeQuery, new Object[] { _assesseeNo }, _asseRowmapper);
//
//			if (retAssesseeList == null || retAssesseeList.size() == 0) {
//				KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//				_busException.setErrMesg("No data exist for the given assessee");
//				throw _busException;
//			} else {
//				returnMap.put(KMCDocumentDownloadConstants.DownloadAppConstants.KMDAAPPLICATIONLIST, retAssesseeList);
//			}
//		} else {
//			returnMap.put(KMCDocumentDownloadConstants.DownloadAppConstants.KMDAAPPLICATIONLIST, retList);
//		}
//
//		_portalServiceReturnObject.setReturnMap(returnMap);
//		return _portalServiceReturnObject;
//	}
//
//	public KMCPortalServiceReturnObject saveAssesseeWaiverApplicationDetails(HashMap infoMap)
//			throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String _schemeType = (String) infoMap.get("SCHEMETYPE");
//		HashMap returnMap = new HashMap();
//		String applicationNo = "";
//		Connection conn = null;
//		String command = "";
//
//		String MOB_NO = (String) infoMap.get("MOB_NO");
//		String TOTAL_AMT = (String) infoMap.get("TOTAL_AMT");
//		String TOTAL_PENALTY = (String) infoMap.get("TOTAL_PENALTY");
//		String TOTAL_INT = (String) infoMap.get("TOTAL_INT");
//		String ACTUAL_PAY = (String) infoMap.get("ACTUAL_PAY");
//		String SUS_AMT = (String) infoMap.get("SUS_AMT");
//		String WARD = (String) infoMap.get("WARD");
//		String APPLICANT_NAME = (String) infoMap.get("APPLICANT_NAME");
//		String APP_DT = (String) infoMap.get("APP_DT");
//		String REMARKS = "I accept terms and conditions";
//
//		String BASIC_DEMAND = (String) infoMap.get("BASIC_DEMAND");
//		String APPLICABLE_INTEREST = (String) infoMap.get("APPLICABLE_INTEREST");
//		String APPLICABLE_PENALTY = (String) infoMap.get("APPLICABLE_PENALTY");
//
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//
//		applicationNo = generateWaiverApplicationNumber(conn);
//
//		applicationNo = "WVR2020/" + _assesseeNo.substring(2, 5) + "/" + applicationNo;
//
//		try {
//
//			command = "{call INSERT_WAIVER2020_APP60(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
//
//			CallableStatement cstmt = conn.prepareCall(command);
//
//			cstmt.setString(1, _assesseeNo);
//			cstmt.setString(2, applicationNo);
//			cstmt.setString(3, MOB_NO);
//			cstmt.setString(4, TOTAL_AMT);
//			cstmt.setString(5, TOTAL_PENALTY);
//			cstmt.setString(6, TOTAL_INT);
//			cstmt.setString(7, ACTUAL_PAY);
//			cstmt.setString(8, SUS_AMT);
//			cstmt.setString(9, WARD);
//			cstmt.setString(10, APPLICANT_NAME);
//			cstmt.setString(11, REMARKS);
//
//			cstmt.setString(12, BASIC_DEMAND);
//			cstmt.setString(13, APPLICABLE_INTEREST);
//			cstmt.setString(14, APPLICABLE_PENALTY);
//			cstmt.setString(15, _schemeType);
//
//			cstmt.execute();
//			cstmt.close();
//		} catch (SQLException e) {
//			System.out.println("Problem in saveAssesseeWaiverApplicationDetails");
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		returnMap.put(KMCAssessmentConstants.AssessmentAppConstants.DEMANDLISTFS, applicationNo);
//		_portalServiceReturnObject.setReturnMap(returnMap);
//		return _portalServiceReturnObject;
//	}
//
//	public String generateWaiverApplicationNumber(Connection conn) {
//
//		PreparedStatement ps = null;
//
//		CallableStatement csUpdate = null;
//		CallableStatement csInsert = null;
//
//		ResultSet rs = null;
//		String receiptNo = "";
//		String eRecptNo = "";
//		HashMap receiptSeqGen = new HashMap();
//		try {
//
//			// String selectStatement = " SELECT ASMT_SEQ_NO FROM ASMT_SEQUENCE_TABLE T
//			// WHERE ASMT_SEQ_NAME = ? FOR UPDATE";
//			String selectStatement = " SELECT ASMT_MAYOR_WAIVER_SEQ.NEXTVAL FROM DUAL";
//			String updateStatement = " UPDATE ASMT_SEQUENCE_TABLE SET ASMT_SEQ_NO = ASMT_SEQ_NO+1 WHERE ASMT_SEQ_NAME = ?  ";
//			String insertTab = " INSERT INTO ASMT_SEQUENCE_TABLE(ASMT_SEQ_NAME, ASMT_SEQ_NO, VER_NO) VALUES (?,?, 1) ";
//			ps = conn.prepareStatement(selectStatement);
//			// ps.setString(1,seqName);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				receiptNo = rs.getString(1);
//				eRecptNo = eRecptNo + receiptNo;
//			}
////         if(!"".equals(receiptNo))
////         {
////              csUpdate = conn.prepareCall("{call "+updateStatement+"}");  
////              csUpdate.setString(1,seqName);
////              csUpdate.executeUpdate();
////         }
////         else
////         {    
////              csInsert = conn.prepareCall("{call "+insertTab+"}");  
////              csInsert.setString(1,seqName);
////              csInsert.setString(2,"2");
////              csInsert.executeUpdate();
////              eRecptNo = eRecptNo+"1";
////           
////         }  
//		} catch (SQLException e) {
//			System.out.println("Problem in generateWaiverApplicationNumber sequence generation");
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ps != null)
//					ps.close();
//				if (csUpdate != null)
//					csUpdate.close();
//				if (csInsert != null)
//					csInsert.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return eRecptNo;
//	}
//
//	public KMCPortalServiceReturnObject getDemandDetailsForWaiverApplication(HashMap infoMap)
//			throws KMCPortalBusinessException {
//
//		KMCPortalServiceReturnObject _portalServiceReturnObject = new KMCPortalServiceReturnObject();
//		String _assesseeNo = (String) infoMap.get("ASSESSENO");
//		String wardNo = _assesseeNo.substring(2, 5);
//		AssessmentCurrentRowMapper _outRowmapper = new AssessmentCurrentRowMapper();
//		List retList = new ArrayList();
//		String sqlQuery = KMCAssessmentConstants.getOutStandingDemandForAssessWaiver();
//		String todate = UtilityForAll.getTodaysDate();
//		String year = KMCAssessmentUtility.getCurrentFinYear();
//		retList = jdbcTemplate.query(sqlQuery,
//				new Object[] { _assesseeNo, wardNo, todate, _assesseeNo, wardNo, year.substring(0, 4) }, _outRowmapper);
//		if (retList == null || retList.size() == 0) {
//			KMCPortalBusinessException _busException = new KMCPortalBusinessException();
//			_busException.setErrMesg("No outstanding demand exist for the given assessee");
//			throw _busException;
//		}
//		_portalServiceReturnObject.setObj(retList);
//		return _portalServiceReturnObject;
//	}
//
//	public String getBiCodeFromAssessee(String _assesseeNo) throws Exception {
//		String dbConnector = KMCPortalPaymentConstants.KMC_PORTAL_PGW_ASMT_CONNECTION;
//		Connection conn = KMCPortalPGConnectionManager.getConnection(dbConnector);
//		PreparedStatement ps = null;
//
//		ResultSet rs = null;
//		String biCode = "";
//
//		HashMap receiptSeqGen = new HashMap();
//		try {
//
//			String selectStatement = "select a.asmt_bi_code bi_code from asmt_bi_code_mst a where a.asmt_bi_code_desc='SUSP' and a.asmt_office_cd= substr(?, 1, 1) ";
//
//			ps = conn.prepareStatement(selectStatement);
//			ps.setString(1, _assesseeNo);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				biCode = rs.getString(1);
//			}
//
//			System.out.println("*************BI Code =" + biCode);
//
//		} finally {
//			if (ps != null)
//				ps.close();
//			if (conn != null)
//				conn.close();
//		}
//		return biCode;
//	}
//
//}*/