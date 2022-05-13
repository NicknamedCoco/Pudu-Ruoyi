const front ={
  state:{
    noticeData: {},
    userData:{}
  },
  mutations:{
    setNoticeData(state,data){
      state.noticeData=data
    },
    setUserData(state,data){
      state.userData=data
    },
  }
}

export default front
