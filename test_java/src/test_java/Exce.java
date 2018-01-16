package test_java;

public class Exce {
	/**
	 * 审核列表导出
	 * @param request
	 * @param Response
	 * @return
	 */
	/*@RequestMapping("/aduiting/export")
	@ResponseBody
	public ReplacePayResponse<Object> auditingExport(HttpServletRequest request,HttpServletResponse Response,TransAuditingDTO transAuditingDto){
		
		LoginUserDetail userObj = (LoginUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	MerchantLoginuserReleationDTO mlrDto = new MerchantLoginuserReleationDTO();
    	mlrDto.setLoginName(userObj.getUsername());
    	
    	ReplacePayResponse<MerchantLoginuserReleationDTO> merchantUserR = rPayMerchantLoginuserReleationService.queryListByCondition(mlrDto);
    	
    	transAuditingDto.setTaUmId(merchantUserR.getData().get(0).getMlrUmId());
		ReplacePayResponse<Object> createUmTaInfoExcel = rPayTransAuditingService.createUmTaInfoExcel(transAuditingDto);
		
		if(createUmTaInfoExcel.getCode() == -1){
			return  createUmTaInfoExcel;
		}
		
		Object object = createUmTaInfoExcel.getData().get(0);
		List<Object> list = new ArrayList<Object>();
		String encoderBASE64 = Base64Coder.encoderBASE64((object + "").getBytes(), true);
		list.add(encoderBASE64);
		createUmTaInfoExcel.setData(list);
		
		return  createUmTaInfoExcel;		
	}
	
	@RequestMapping("/aduiting/download/{filepath}")
	public void download(HttpServletRequest request,HttpServletResponse response, @PathVariable("filepath") String filepath){
		String path = new String(Base64Coder.decodeBASE64(filepath));
        try {
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();

            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
        	log.error("对账文件导出异常", ex);
        }	
	}*/
	
}
