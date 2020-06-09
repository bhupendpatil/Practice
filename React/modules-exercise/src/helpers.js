function choice(item){
    let choicee = Math.floor(Math.random() * item.length);
    return item[choicee];
}

function remove(items,item){
    for(let i=0;i<items.length;i++){
        if(items[i]===item){
            return [ ...items.slice(0,i),...items.slice(i+1) ];
        }
    }
}

export {choice,remove};