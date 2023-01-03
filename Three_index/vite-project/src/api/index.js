
import axios from 'axios';

// 支持async/await用法
export const getData = async (current) => {
    try {
        const response = await axios.get(`http://localhost:8090/getEntities?current=${current}`);

        return response.data.data.records
        
      } catch (error) {
        console.error(error);
      }
 } 

 export const getData1 = async (cx,sfzrkmc,sfzckmc) => {
    try {
        const response = await axios.get(`http://localhost:8090/getEntitiesList?cx=${cx}&sfzrkmc=${sfzrkmc}&sfzckmc=${sfzckmc}`);

        return response.data.data.records
        
      } catch (error) {
        console.error(error);
      }
 } 