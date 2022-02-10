import React, {useState, useRef, useCallback, useEffect} from "react"
import { useSelector } from 'react-redux';
import DatePicker from "react-datepicker"
import axios from 'axios'
import {Button} from "react-bootstrap";
import "./Post.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import "react-datepicker/dist/react-datepicker.css";
import { useHistory } from 'react-router-dom';

const Post = () => {
	//
	const state = useSelector(state => state.alarmData);
	const history = useHistory();
	if (localStorage.getItem('loginedUser') === null) {
        history.push('/')
    }
	// 

	const userData = state[0]
	//
	
	const inputPlus = () => {
		return (
			<input type="text" name="input_area" size="30" placeholder="투표항목을 입력하세요"></input>
		)
	}

	//axios post 데이터
	const [userId, setUserId] = useState(1) // 유저 id
	const [type, setType] = useState(null)
	const [revealType, setRevealType] = useState(null) // 공개범위
	const [voteContent, setVoteContent] = useState("") // 내용
	const [voteItems, setVoteItems] = useState(["", ""]) // 투표항목
	const [img, setImg] = useState(null) // 이미지
	const [hashArr, setHashArr] = useState([]) // 해시태그
	const [dueDate, setDueDate] = useState(Date.now() + 86400000); // 마감시간
	//


	// axios.post
	function postAPI() {
		const url = "http://localhost:8080/board/save"
		const vote_contents = JSON.stringify(voteItems)
		
		axios({
			method: "post",
			url: url,
			data: {
				// userId: userId,
				type: type,
				view_range: revealType,
				content: voteContent,
				vote_contents: vote_contents,
				// board_image: img,
				hashArr: JSON.stringify(hashArr),
				due_date: dueDate,
			},
		})
		.then(function (response) {
			console.log(response.config.data)
		})
		.catch(function(error) {
			console.log(error)
		})
	}
	//

	// function getAPI() {
	// 	const url = "https://75e689af-277f-4239-8228-f14b051043ac.mock.pstmn.io/post"

	// 	axios({
	// 		method: 'get',
	// 		url: url
	// 	})
	// 	.then(function (response) {
	// 		console.log(response)
	// 	})
	// 	.catch(function(error) {
	// 		console.log(error)
	// 	})
	// }

	//

	const [selected, setSelected] = useState(false)
	const [keySelected, setKeySelected] = useState(null)
	const [hashtag, setHashtag] = useState('')
	const [isErrored, setIsErrored] = useState(false)
	const [votes, setVote] = useState([{id: 0, value: inputPlus()}])
	
	const nextId = useRef(1)
	const ref = useRef(null)

	const addEvent = useCallback(
		(event) => {
			const vote = { id: nextId.current, value: inputPlus() }
			setVote(votes.concat(vote))	
			nextId.current += 1
			event.preventDefault()
		},
		[votes]
	)

	const removeEvent = (event, props) => {
		setVote(votes.filter(item => item.id !== props.id))
		event.preventDefault()
	}

	const changeHashtag = (event) => {
		return (
			setHashtag(event.target.value)
		)
	} 

	const inputTextArea = (event) => {
		return (
			setVoteContent(event.target.value),
			console.log(event.target.value)
		)
	}

	const getVoteItems = (event, idx) => {
		const items = voteItems
		items[idx] = event.target.value
		setVoteItems(items)
		console.log(voteItems)
	}

	const addVoteList = () => {
		setVoteItems(oldArray => [...oldArray, ""])
		console.log(voteItems)
	}

	const removeVoteList = (event, idx) => {
		const items = voteItems
		items.splice(idx, 1)
		setVoteItems(items)
		console.log(voteItems)
	}

	const inputHashtag = (event) => {
		if (event.keyCode === 13 || event.type === 'click') {
			setIsErrored(false)
			if (hashtag.length > 0) {
				if (hashArr.length <= 4) {
					if (hashArr.indexOf(event.target.value) === -1) {
						if (event.target.value.length <= 10) {
							return (
								setHashArr(oldArray => [...oldArray, hashtag]),
								setHashtag('')
							)
						} else {
							setIsErrored(true)
							console.log("최대 길이 10자")
						}
					} else {
						setIsErrored(true)
						console.log("중복됩니다")
					}
				} else {
					setIsErrored(true)
					console.log("최대 개수 5개")
				}
			}
		} 		
	}

	useEffect(() => {
		const handleClickOutside = (event) => {
			if (isErrored && ref.current && !ref.current.contains(event.target)) {
				setIsErrored(false)
			}
		}
	
		document.addEventListener("mousedown", handleClickOutside)
	
		return () => {
			document.removeEventListener("mousedown", handleClickOutside)
		}
	}, [isErrored])

	const removeHashtag = (event, value) => {
		const tempArr = hashArr.filter(tag => tag !== value)
		return (
			setHashArr(tempArr)
		)
	}

	// const saveImg = (event) => {
	// 	setImg(URL.createObjectURL(event.target.files[0]))
	// }

	// 이미지 업로드 테스트
	const saveImg = (event) => {
		event.preventDefault();

		if(event.target.files) {
			const uploadFile = event.target.files[0]
			const formData = new FormData()
			formData.append('uploadFile', uploadFile)
			
			setImg(formData)
			// const url = "https://75e689af-277f-4239-8228-f14b051043ac.mock.pstmn.io/post"
			
			// axios({
			// 	method: "post",
			// 	url: url,
			// 	data: formData,
			// 	headers: { "Content-Type": "multipart/form-data" },
			// })
			// .then(function (response) {
			// 	console.log(response)
			// })
			// .catch(function(error) {
			// 	console.log(error)
			// })
		}
	}
	//

	const deleteImg = (event) => {
		// URL.revokeObjectURL(img)
		setImg(null)
	}

	// 마감 시간
    const filterPassedTime = (time) => {
        const currentDate = new Date();
        const selectedDate = new Date(time);
        return currentDate.getTime() < selectedDate.getTime();
    };
	//

	const contentReset = (key) => {
		if (key !== keySelected) {
			setKeySelected(key)
			setVoteContent("")
			setVoteItems(["", ""])
			setVote([{id: 0, value: inputPlus()}])
			setImg(null)
			const allTextArea = document.getElementsByName("text_area")
			const allInputArea = document.getElementsByName("input_area")
			console.log(allInputArea)

			for (var i = 0; i < 3; i++) {
				allTextArea[i].value = ''
			}

			for (var j = 0; j < allInputArea.length; j++) {
				allInputArea[j].value = ''
			}
			
		} 
	}

	return (
		<>
			<div className="container" style={{zIndex: '-100'}} >
				<div className="mb-5">
					<h1 style={{ marginTop: '20px' }}>
						<b>글작성</b>
					</h1>
				</div>
				<div className="mb-3 d-flex flex-row align-items-center">
					<div>
						<img src='' alt="Avatar" className="avatar"></img>
					</div>
					<div className="m-1">
						dfg
					</div>
				</div>
				<div>
					<div className="my_accordion">
						<div className="title active" onClick={() => setSelected(!selected)}>
							<div>공개범위</div>
						</div>
						<div className='content show'>
							<div className='content__radio' onClick={() => setRevealType("전체공개")}>
								<input
									type="radio"
									id="reveal_all"
									name="reveal_bounds"
									value="reveal_all"
								/>
								<label style={{marginLeft: "5px"}} for="reveal_all">전체공개</label>
							</div>
							<div className="content__radio" onClick={() => setRevealType("친구공개")}>
								<input
									type="radio"
									id="reveal_friend"
									name="reveal_bounds"
									value="reveal_friend"
								/>
								<label style={{marginLeft: "5px"}} for="reveal_friend">친구공개</label>
							</div>
						</div>
					</div>
					<div className="mt-4">
						<div className="title active" onClick={() => setSelected(!selected)}>
							<div>글종류</div>
						</div>
						<div className="button_group">
							<div className="button_vote" onClick={() => {setType(1); contentReset("1")}}>
								<div><i class="bi bi-card-checklist"></i></div>
								<div>투표</div>
							</div>
							<div className="button_ox" onClick={() => {setType(2); contentReset("2")}}>
								<div><i class="h6 bi bi-circle"></i><i class="h6 bi bi-x-lg"></i></div>
								<div>찬반</div>
							</div>
							<div className="button_ox" onClick={() => {setType(3); contentReset("3")}}> 
								<div>VS</div>
								<div>대결</div>
							</div>
						</div>

						{/* 투표 */}
						<div className="my_accordion"> 
							{/* <div className={keySelected === '1' ? "title active" : "title"} onClick={() => {setType(1); contentReset("1")}}>
								<div>투표</div>
								<div className={keySelected === '1' ? "chevron active" : "chevron"}><i className="h4 bi bi-chevron-down"></i></div>
							</div> */}
							<div className={keySelected === '1' ? "vote_content show" : "vote_content"}>
								<textarea className="textarea" name="text_area" id="" cols="40" rows="8" placeholder="내용을 입력하세요" onChange={inputTextArea}></textarea>
								<div className="d-flex flex-row">
									<div className="mx-2">
										<button type="button" className="btn btn-primary btn-sm" onClick={(event) => {addEvent(event); addVoteList();}}>
											<i className="bi bi-plus-lg"></i>
										</button>
									</div>
									<div>
										{votes.map((props, idx) => (
											<div className="vote_box mb-2" key={props.id}>
												<div onChange={(event) => {getVoteItems(event, idx)}}>
													{props.value}
												</div>
												<button type="button" className="m-1 btn btn-sm btn-danger" onClick={(event) => {removeEvent(event, props); removeVoteList(event, idx)}}>
													<i className="bi bi-x-lg"></i>
												</button>
											</div>
										))}
									</div>	
								</div>
								<div className={img ? "imgDelete show" : "imgDelete"}>
									<button onClick={deleteImg}>x</button>
								</div>
								<div className="img_box">
									<div>
										{img && ( <img alt="sample" src={img} className="thumbnail" /> )}
									</div>
									<div style={{ marginLeft: "10px" }}>
										<input id="imgFile" name="imgUpload" type="file" accept="image/*" onChange={saveImg} style={{display:"none"}}/>
										<label className="button2" for="imgFile">
											사진 업로드
										</label>
									</div>
								</div>
							</div>
						</div>

						{/* OX */}
						<div className="my_accordion">
							{/* <div className={keySelected === '2' ? "title active" : "title"} onClick={() => {contentReset("2"); setVoteItems(["", ""]); setType(2)}}>
								<div>OX</div>
								<div className={keySelected === '2' ? "chevron active" : "chevron"}><i className="h4 bi bi-chevron-down"></i></div>
							</div> */}
							<div className={keySelected === '2' ? "vote_content show" : "vote_content"}>
								<textarea className="textarea" name="text_area" id="" rows="8" placeholder="내용을 입력하세요" onChange={inputTextArea}></textarea>
								<div className={img ? "imgDelete show" : "imgDelete"}>
									<button onClick={deleteImg}>x</button>
								</div>
								<div className="img_box">
									<div>
										{img && ( <img alt="sample" src={img} className="thumbnail" /> )}
									</div>
									<div style={{ marginLeft: "10px" }}>
										<input id="imgFile" name="imgUpload" type="file" accept="image/*" onChange={saveImg} style={{display:"none"}}/>
										<label className="button2" for="imgFile">
											사진 업로드
										</label>
									</div>
								</div>
							</div>
						</div>

						{/* VS */}
						<div className="my_accordion">
							{/* <div className={keySelected === '3' ? "title active" : "title"} onClick={() => {contentReset("3"); setVoteItems(["", ""]); setType(3)}}>
								<div>VS</div>
								<div className={keySelected === '3' ? "chevron active" : "chevron"}><i className="h4 bi bi-chevron-down"></i></div>
							</div> */}
							<div className={keySelected === '3' ? "vote_content show" : "vote_content"}>
								<textarea className="textarea" name="text_area" id="" rows="8" placeholder="내용을 입력하세요" onChange={inputTextArea}></textarea>
								<div className={img ? "imgDelete show" : "imgDelete"}>
									<button onClick={deleteImg}>x</button>
								</div>
								<input type="text" name="input_area" size="30" placeholder="항목을 입력하세요" onChange={(event) => {getVoteItems(event, 0)}}></input>
								<div className="img_box">
									<div>
										{img && ( <img alt="sample" src={img} className="thumbnail" /> )}
									</div>
									<div style={{ marginLeft: "10px" }}>
										<input id="imgFile1" name="imgUpload1" type="file" accept="image/*" onChange={saveImg} style={{display:"none"}}/>
										<label className="button2" for="imgFile1">
											사진 업로드
										</label>
									</div>
								</div>
								<input type="text" size="30" name="input_area" placeholder="항목을 입력하세요." onChange={(event) => {getVoteItems(event, 1)}}></input>
								<div className="img_box">
									<div>
										{img && ( <img alt="sample" src={img} className="thumbnail" /> )}
									</div>
									<div style={{ marginLeft: "10px" }}>
										<input id="imgFile2" name="imgUpload2" type="file" accept="image/*" onChange={saveImg} style={{display:"none"}}/>
										<label className="button2" for="imgFile2">
											사진 업로드
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>				
				</div>
				<div className="title active mt-4 ">
					<div>#태그 입력</div>
				</div>
				<div className="hashtag_outer">
					{hashArr.map((value, key) => (
						<div key={key}>
							<div className="hashtag_inner">
								<div>{value}</div>
								<div 
									style={{marginLeft: '5px'}}
									className="hashtag_remove"
									onClick={(event) => removeHashtag(event, value)}
								>
									<i class="bi bi-x-lg"></i>
								</div>
							</div>
							
						</div>
					))}
				</div>
				<div className="input_area">
					<input
						type="text"
						value={hashtag}
						placeholder="해시태그를 입력하세요."
						onChange={changeHashtag}
						onKeyUp={inputHashtag}
						className="hashtag_input"
						autoFocus
					/>
					<button onClick={inputHashtag} className="input_button btn btn-primary btn-sm">+</button>
				</div>
				<div className={isErrored ? "bubble active" : "bubble"} ref={ref}>
					<ul style={{margin: 0}}>
						<li>태그의 길이는 10자 이하로 작성합니다.</li>
						<li>최대 5개의 태그를 입력할 수 있습니다.</li>
					</ul>
				</div>
				<div style={{marginTop: "30px"}}>마감시간</div>
				<div>
					<DatePicker
						selected={dueDate}
						onChange={(date) => setDueDate(date)}
						showTimeSelect
						filterTime={filterPassedTime}
						dateFormat="MMMM d, yyyy h:mm aa"
				/>
				</div>
				<div className="mt-4" align="right">
					<form action="">
						<Button variant="primary" onClick={postAPI}>작성</Button>
					</form>
				</div>

				{/* <div>
					<button onClick={getAPI}>++++</button>
				</div> */}
			</div>
		</>
	)
}

export default Post