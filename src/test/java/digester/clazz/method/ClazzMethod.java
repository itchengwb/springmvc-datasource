package digester.clazz.method;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/8/13  1:48
 * Discribe: Template
 */
public class ClazzMethod {
    public static void main(String[] args) {
       // String clazzNames = "com.fuscent.core.service.IUserService;com.fuscent.core.service.ILoanService;com.fuscent.core.service.ILoanInvestorService;com.fuscent.core.service.IUserInfoService;com.fuscent.core.service.IUserPicService;com.fuscent.core.service.IAuthenRecordService;com.fuscent.core.service.ILoanPicService;com.fuscent.core.service.IIpAddressLocationService;com.fuscent.core.service.ILoanCommentService;com.fuscent.core.service.ILoanManageService;com.fuscent.core.service.IThirdPartyService;com.fuscent.core.service.IInnerMailService;com.fuscent.core.service.IUserNoticeService;com.fuscent.core.service.IInvestorService;com.fuscent.core.service.ICashWithdrawService;com.fuscent.core.service.IBlackListService;com.fuscent.core.service.IBorrowerService;com.fuscent.core.service.INotificationConfigService;com.fuscent.core.service.IUserSecurityQuestionService;com.fuscent.core.service.ICreditReportService;com.fuscent.core.service.ICreditMaterialService;com.fuscent.core.service.IExpertScoreCardService;com.fuscent.core.service.ICreditRightsService;com.fuscent.core.service.ILoanQuartzService;com.fuscent.core.service.ICollectionService;com.fuscent.core.service.IUserStatisticService;com.fuscent.core.service.IPlatformStatisticsService;com.fuscent.core.service.IUserInvitedService;com.fuscent.core.service.IUserVipInvestorService;com.fuscent.core.service.IUserAutoInvestService;com.fuscent.core.service.IFinancialReportService;com.fuscent.core.service.ICouponService;com.fuscent.core.service.IFinancePlanService;com.fuscent.core.service.IInterlinkageService;com.fuscent.core.service.IKeyValueCacheService;com.fuscent.core.service.ILoanCacheService;com.fuscent.core.service.ICreditRightCacheService;com.fuscent.core.service.IUserCacheService;com.fuscent.core.service.IChannelCacheService;com.fuscent.core.service.IInvestRankingService;com.fuscent.core.service.ICoreApiService;com.fuscent.core.service.ISmsService;com.fuscent.core.service.ICashFlowCheckService;com.fuscent.core.service.INewsService;com.fuscent.core.service.IFinancePlanCacheService;com.fuscent.core.service.IPromotionMgmtService;com.fuscent.core.service.IPromotionService;com.fuscent.core.service.IRefundService;com.fuscent.core.service.ICoreLoanOrgService;com.fuscent.core.service.ICoreFinanceOrgService;com.fuscent.core.service.IElectronicReceiptService;com.fuscent.core.service.IThirdPartyChannelService;com.fuscent.core.service.IQuickPaymentService;com.fuscent.core.service.ISemVisitRecordService;com.fuscent.core.service.ICurrencyFundService;com.fuscent.core.service.ICurrencyFundMgmtService;com.fuscent.core.service.IFinancePlanVService;com.fuscent.core.service.IMgmtReportService;com.fuscent.core.service.ISecondContactService;com.fuscent.core.service.IAppointmentMgmtService;com.fuscent.core.service.IRechargeService;com.fuscent.core.service.IAppointmentService;com.fuscent.core.service.IChannelService;com.fuscent.core.service.IFinancePlanStatisticsService;com.fuscent.core.service.DKidCardService;com.fuscent.core.service.INoviceCacheService;com.fuscent.core.service.IThirdPartyPayService;com.fuscent.core.service.IRedemptionService;com.fuscent.core.service.IPartiallyAdvanceReturnRecordService";
        String clazzNames = "com.fuscent.core.service.IUserService;com.fuscent.core.service.ILoanService;com.fuscent.core.service.IRemittanceService;com.fuscent.core.service.ILoanInvestorService;com.fuscent.core.service.IPartiallyAdvanceReturnRecordService;com.fuscent.core.service.IUserInfoService;com.fuscent.core.service.IUserPicService;com.fuscent.core.service.IAuthenRecordService;com.fuscent.core.service.ILoanPicService;com.fuscent.core.service.IBankCardService;com.fuscent.core.service.IIpAddressLocationService;com.fuscent.core.service.ILoanCommentService;com.fuscent.core.service.IThirdPartyService;com.fuscent.core.service.IInnerMailService;com.fuscent.core.service.ILoanManageService;com.fuscent.core.service.IUserNoticeService;com.fuscent.core.service.IInvestorService;com.fuscent.core.service.ICashWithdrawService;com.fuscent.core.service.IBlackListService;com.fuscent.core.service.IBorrowerService;com.fuscent.core.service.INotificationConfigService;com.fuscent.core.service.IUserSecurityQuestionService;com.fuscent.core.service.ICreditReportService;com.fuscent.core.service.ICreditMaterialService;com.fuscent.core.service.IExpertScoreCardService;com.fuscent.core.service.ICreditRightsService;com.fuscent.core.service.ILoanQuartzService;com.fuscent.core.service.ICollectionService;com.fuscent.core.service.IUserStatisticService;com.fuscent.core.service.IPlatformStatisticsService;com.fuscent.core.service.IUserInvitedService;com.fuscent.core.service.IUserVipInvestorService;com.fuscent.core.service.IUserAutoInvestService;com.fuscent.core.service.IFinancialReportService;com.fuscent.core.service.ICouponService;com.fuscent.core.service.IFinancePlanService;com.fuscent.core.service.IInterlinkageService;com.fuscent.core.service.IKeyValueCacheService;com.fuscent.core.service.ILoanCacheService;com.fuscent.core.service.ICreditRightCacheService;com.fuscent.core.service.IUserCacheService;com.fuscent.core.service.IChannelCacheService;com.fuscent.core.service.IInvestRankingService;com.fuscent.core.service.ICoreApiService;com.fuscent.core.service.ISmsService;com.fuscent.core.service.ICashFlowCheckService;com.fuscent.core.service.INewsService;com.fuscent.core.service.IFinancePlanCacheService;com.fuscent.core.service.IPromotionService;com.fuscent.core.service.IPromotionMgmtService;com.fuscent.core.service.IRefundService;com.fuscent.core.service.ICoreLoanOrgService;com.fuscent.core.service.ICoreFinanceOrgService;com.fuscent.core.service.IElectronicReceiptService;com.fuscent.core.service.IThirdPartyChannelService;com.fuscent.core.service.IQuickPaymentService;com.fuscent.core.service.ISemVisitRecordService;com.fuscent.core.service.ICurrencyFundService;com.fuscent.core.service.ICurrencyFundMgmtService;com.fuscent.core.service.IFinancePlanVService;com.fuscent.core.service.IMgmtReportService;com.fuscent.core.service.ISecondContactService;com.fuscent.core.service.IAppointmentService;com.fuscent.core.service.IAppointmentMgmtService;com.fuscent.core.service.IRechargeService;com.fuscent.core.service.IRedemptionService;com.fuscent.core.service.IUserSignService;com.fuscent.core.service.IUmpayTransService;com.fuscent.core.service.INeedCancelTranService;com.fuscent.core.service.IChannelService;com.fuscent.core.service.IFinancePlanStatisticsService;com.fuscent.core.service.DKidCardService;com.fuscent.core.service.INoviceCacheService;com.fuscent.core.service.IRechargeCancelPayService;com.fuscent.core.service.IThirdPartyPayService;com.fuscent.core.service.ILoanExtentionService;com.fuscent.core.service.IVWealthUserService;com.fuscent.core.service.IThirdPartyManagerService;";
       String[] clazzNamesArr = clazzNames.split(";");


        //获取包下面所有方法
        int count = 0;
        for(String clazzName:clazzNamesArr){
            count = getMethodInfo(clazzName,count) +count;
            System.out.println("=========================end===========================");
        }
        System.out.println(count);


        //获取文件夹下面所有的文件：
        //D:\dev\workspace-yooli\core\core\yooli-api\src\main\java\com\fuscent\core\service
       /* String path = "D:\\dev\\workspace-yooli\\core\\core\\yooli-api\\src\\main\\java\\com\\fuscent\\core\\service";
        getFileInfo(path);*/

    }

    /**
     * 获取目录下所有文件
     * @param path
     */
    public static void getFileInfo(String path){
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数："+tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文     件："+tempList[i]);
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹："+tempList[i]);
            }
        }
    }
    /**
     * 传入全类名获得对应类中所有方法名和参数名
     */
    @SuppressWarnings("rawtypes")
    private static int  getMethodInfo(String pkgName,int count) {
        try {
            Class clazz = Class.forName(pkgName);
            Method[] methods = clazz.getMethods();
            System.out.println(pkgName);
            for (Method method : methods) {
                String methodName = method.getName();

                Class<?>[] parameterTypes = method.getParameterTypes();
                String parms = "";
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    if("".equals(parms) && parameterName != null){
                        parms = parameterName;
                    }else{
                        parms = parms+",  "+parameterName;
                    }
                }
                System.out.println( methodName+"("+parms+")");
               // System.out.println();
               // System.out.println("*****************************");
            }
            count += methods.length;
           System.out.println("方法总个数："+methods.length);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

}
