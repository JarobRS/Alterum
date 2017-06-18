var Page = {
  /**
   * e.g. {
   *   '-1231_132': true,
   *   '-4552_22': false
   * }
   */
  _isAdPost: {},

  // mainly used in image paste from clipboard (see Emoji)
  initUploadForImagePaste: function(txtEl, addMedia, blob) {  showMore: function(offset) {
                                                                if (cur.viewAsBox) return cur.viewAsBox();
                                                                if (cur.wallLayer) return;
                                                                if (cur.wallTab == 'suggested') return Wall.suggestMore();

                                                                var type = cur.wallType,
                                                                    more = ge('wall_more_link'),
                                                                    wallNextFrom = cur.wallNextFrom || '',
                                                                    tmp = cur.wallLoading = cur.oid;
                                                                ajax.post('al_wall.php', {act: 'get_wall', owner_id: cur.oid, offset: offset, type: type, fixed: cur.options.fixed_post_id || '', wall_start_from: wallNextFrom}, {
                                                                  onDone: function (rows, names, videos, newNextFrom) {
                                                                    if (tmp !== cur.oid) return;
                                                                    delete(cur.wallLoading);
                                                                    setTimeout(Wall.receive.pbind(rows, names), 0);
                                                                    if (cur.wallVideos) {
                                                                      each(videos, function(playlistId, playlist) {
                                                                        if (cur.wallVideos[playlistId]) {
                                                                          cur.wallVideos[playlistId].list = cur.wallVideos[playlistId].list.concat(playlist.list);
                                                                        }
                                                                      });
                                                                    }
                                                                    cur.wallNextFrom = newNextFrom;
                                                                  },
                                                                  showProgress: lockButton.pbind(more),
                                                                  hideProgress: unlockButton.pbind(more)
                                                                });
                                                              }
}

if (!window._postsSendTimer) _postsSendTimer = setTimeout(Page.postsSend, 10000);

try{stManager.done('page.js');}catch(e){}
