// 1. what is API
// 2. How do I call API
// 3. Explain code
// const host = "https://provinces.open-api.vn/api/";
const host = "https://vapi.vnappmob.com/api/province/";

// function thực hiện call API
var callAPI = (api) => {
    return axios.get(api)
        .then((response) => {
            // console.log(response.data.results);
            renderData(response.data.results, "province");
            // console.log("Result call API : " + response.data);
        });
}

// truyền API vào hàm với tham số depth=1 , chỉ lấy ra tỉnh/thành phố
// callAPI('https://provinces.open-api.vn/api/?depth=1');
callAPI('https://vapi.vnappmob.com/api/province/');
// lấy ra district : quận/huyện
var callApiDistrict = (api) => {
    return axios.get(api)
        .then((response) => {
            // console.log(response.data.results);
            renderDataDistrict(response.data.results, "district");
        });
}

// lấy ra ward : xã / phường
var callApiWard = (api) => {
    return axios.get(api)
        .then((response) => {
            renderDataWard(response.data.results, "ward");
        });
}

// render ra data là 1 array, select
// in ra danh sách các tỉnh
var renderData = (array, select) => {
    if (!Array.isArray(array)) {
        console.log('Data is not an array');
        return;
    }

    let options = '<option disabled value="">Chọn</option>';
    array.forEach(element => {
        options += `<option value="${element.province_id}">${element.province_name}</option>`;
    });
    document.querySelector("#" + select).innerHTML = options;
}


var renderDataDistrict = (array, select) => {
    if (!Array.isArray(array)) {
        console.log('Data is not an array');
        return;
    }

    let options = '<option disabled value="">Chọn</option>';
    array.forEach(element => {
        options += `<option value="${element.district_id}">${element.district_name}</option>`;
    });
    document.querySelector("#" + select).innerHTML = options;
}


var renderDataWard = (array, select) => {
    if (!Array.isArray(array)) {
        console.log('Data is not an array');
        return;
    }

    let options = '<option disabled value="">Chọn</option>';
    array.forEach(element => {
        options += `<option value="${element.ward_id}">${element.ward_name}</option>`;
    });
    document.querySelector("#" + select).innerHTML = options;
}

// https://vapi.vnappmob.com/api/province/district/01

// const host = "https://vapi.vnappmob.com/api/province/";

//  https://vapi.vnappmob.com/api/province/d/31?depth=2
$("#province").change(() => {
    callApiDistrict(host + "district/"  + $("#province").val() );
    // console.log("callApiDistrict : " +  host + "district/"  + $("#province").val());
    // printResult();
});

// GET https://vapi.vnappmob.com/api/province/ward/271
$("#district").change(() => {
    callApiWard(host + "ward/" + $("#district").val() );
    // console.log("callApiWard : " +  host + "ward/" + $("#district").val() );
    // printResult();
});
$("#ward").change(() => {
    // printResult();
})

// var printResult = () => {
//     if ($("#district").val() != "" && $("#province").val() != "" && $("#ward").val() != "") {
//         let result = $("#province option:selected").text() +
//             " | " + $("#district option:selected").text() + " | " +
//             $("#ward option:selected").text();
//         $("#result").text(result)
//     }

// }